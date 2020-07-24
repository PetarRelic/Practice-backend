package it.eng.petarrelic.vezba.resource;

import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/appInfos", produces = {MediaType.TEXT_PLAIN_VALUE})
public class AppInfoResource {

	@Value("${spring.application.name}")
	private String applicationName;
	
	@GetMapping
	public String getAppInfo() {
		return getInfo();
	}
	
	private String getInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Application name: " + applicationName);
		stringBuilder.append("\n\nServer time: " + LocalDateTime.now());
		stringBuilder.append("\nTime zone: " + TimeZone.getDefault().getID());
		
		return stringBuilder.toString();
	}
}
