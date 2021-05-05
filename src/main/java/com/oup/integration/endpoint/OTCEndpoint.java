package com.oup.integration.endpoint;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
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
	public ZTESTSCHEMAResponse submitOTCSchema(@RequestPayload ZTESTSCHEMARequest request) throws JAXBException {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("com.sap.document.sap.rfc.functions");
		Map<String, Object> properties = new HashMap<>();
		properties.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxb2Marshaller.setMarshallerProperties(properties);

		Marshaller marshaller = jaxb2Marshaller.createMarshaller();
		marshaller.marshal(request, System.out);
		File file = new File("IN/output");
		marshaller.marshal(request, file);
		ZTESTSCHEMAResponse response = new ZTESTSCHEMAResponse();
		response.setHttpStatus("OK");
		response.setMessage("Succefully submitted.");
		return response;
	}
}
