package com.oup.integration.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.sap.document.sap.rfc.functions.ZTESTSCHEMARequest;
import com.sap.document.sap.rfc.functions.ZTESTSCHEMAResponse;

@Endpoint
public class OTCEndpoint {
	private static final String NAMESPACE_URI = "urn:sap-com:document:sap:rfc:functions";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "ZTEST_SCHEMARequest")
	@ResponsePayload
	public ZTESTSCHEMAResponse submitOTCSchema(@RequestPayload ZTESTSCHEMARequest request) {
		ZTESTSCHEMAResponse response = new ZTESTSCHEMAResponse();
		response.setHttpStatus("OK");
		response.setMessage("Succefully submitted.");
		return response;
	}
}
