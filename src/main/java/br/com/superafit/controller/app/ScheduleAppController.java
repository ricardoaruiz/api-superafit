package br.com.superafit.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.superafit.controller.model.response.ListScheduleResponse;
import br.com.superafit.service.ScheduleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("app/schedule")
public class ScheduleAppController {

	@Autowired
	private ScheduleService scheduleService;
	
	@ApiOperation(value = "list", nickname = "list")		
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "OK", response = ListScheduleResponse.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 500, message = "Internal Server Error")}) 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<ListScheduleResponse> list() {
		ListScheduleResponse schedules = scheduleService.list();
		return schedules == null || schedules.getSchedules() == null || schedules.getSchedules().isEmpty()
				? ResponseEntity.noContent().build() : ResponseEntity.ok(schedules);
	}
	
}
