package br.com.superafit.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.superafit.controller.model.request.ResendMessageRequest;
import br.com.superafit.controller.model.request.SendMessageRequest;
import br.com.superafit.enumeration.MessageCodeEnum;
import br.com.superafit.model.Message;
import br.com.superafit.repository.MessageRepository;
import br.com.superafit.retrofit.service.model.FirebaseDataNotificationRequest;
import br.com.superafit.service.domain.IMessage;
import br.com.superafit.service.exception.MessageNotFoundException;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private FirebaseService firebaseService;
	
	public void send(IMessage message) {
		sendFcm(message);
		messageRepository.save(getMessage(message));
	}
	
	public void resend(ResendMessageRequest request) {
		Message message = messageRepository.findOne(request.getId());
		if(message == null) {
			throw new MessageNotFoundException(MessageCodeEnum.Constants.SEND_MESSAGE_NOT_FOUND);
		}
		sendFcm(getImessage(message));
		message.setSent(true);
		messageRepository.save(message);
	}

	private void sendFcm(IMessage message) {
		FirebaseDataNotificationRequest dataNotification = new FirebaseDataNotificationRequest("Superafit", "Nova mensagem");
		dataNotification.putData("message", message);			
		firebaseService.send(dataNotification);
	}
	
	private Message getMessage(IMessage message) {
		Message m = new Message();
		m.setText(message.getText());
		m.setDate(new Date());
		m.setSent(true);
		return m;
	}
	
	private IMessage getImessage(Message message) {
		SendMessageRequest request = new SendMessageRequest();
		request.setText(message.getText());
		return request;
	}	
		
}
