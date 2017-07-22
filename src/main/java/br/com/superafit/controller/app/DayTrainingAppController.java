package br.com.superafit.controller.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.response.GetDayTrainingResponse;
import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.service.DayTrainingService;
import br.com.superafit.service.domain.ListTrainning;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("app/day-training")
public class DayTrainingAppController {

	@Autowired
	private DayTrainingService trainingDayService;
		
	@ApiOperation(value = "getTraining", nickname = "getTraining")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Ok", response = ListScheduleResponse.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<GetDayTrainingResponse> getDayTraining(
			@RequestParam(value="date", required=true)
			@DateTimeFormat(pattern="dd/MM/yyyy")
			Date date) {
		
		ListTrainning dayTraining = trainingDayService.getDayTraining(date);
		
		GetDayTrainingResponse response = new GetDayTrainingResponse(dayTraining.getTrainnings(), dayTraining.isSync());		
		return !response.hasTraining() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
	}
	
}
