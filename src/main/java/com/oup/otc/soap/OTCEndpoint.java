package com.oup.otc.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.ZTESTSCHEMARequest;
import io.spring.guides.gs_producing_web_service.ZTESTSCHEMAResponse;

@Endpoint
public class OTCEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ZTEST_SCHEMARequest")
	@ResponsePayload
	public ZTESTSCHEMAResponse getCountry(@RequestPayload ZTESTSCHEMARequest request) {
		ZTESTSCHEMAResponse response = new ZTESTSCHEMAResponse();
		response.setHttpStatus("OK");
		response.setMessage("Succefully submited.");
		return response;
	}
}
