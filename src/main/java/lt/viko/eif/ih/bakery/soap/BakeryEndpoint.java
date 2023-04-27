package lt.viko.eif.ih.bakery.soap;

import lt.viko.eif.ih.bakery.soap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class BakeryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private BakeryRepository bakeryRepository;

    @Autowired
    public BakeryEndpoint(BakeryRepository bakeryRepository) {
        this.bakeryRepository = bakeryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBakeryRequest")
    @ResponsePayload
    public GetBakeryResponse getBakery(@RequestPayload GetBakeryRequest request) {
        GetBakeryResponse response = new GetBakeryResponse();
        response.setBakery(bakeryRepository.findBakery(request.getName()));

        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBakeryByCustomerRequest")
    @ResponsePayload
    public GetBakeryByCustomerResponse getBakeryByCustomer(@RequestPayload GetBakeryByCustomerRequest request) {
        GetBakeryByCustomerResponse response = new GetBakeryByCustomerResponse();
        response.setBakery(bakeryRepository.findBakeryByCustomer(request.getFirstName(), request.getLastName()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCartByCustomerRequest")
    @ResponsePayload
    public GetCartByCustomerResponse getCartByCustomer(@RequestPayload GetCartByCustomerRequest request) {
        GetCartByCustomerResponse response = new GetCartByCustomerResponse();
        response.getCart().addAll(bakeryRepository.findCartByCustomer(request.getFirstName(), request.getLastName()));
        return response;
    }
}
