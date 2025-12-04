package auth.server.hw.controller;


import auth.server.hw.dto.client.AuthorizationCodeRequest;
import auth.server.hw.dto.client.ClientCredentialsRequest;
import auth.server.hw.dto.client.ResponseClient;
import auth.server.hw.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Create PKCE Client
    @PostMapping("/pkce")
    public ResponseEntity<ResponseClient> createPKCEClient(
            @Valid @RequestBody AuthorizationCodeRequest request) {
        request.setAuthCodeType("pkce");
        request.setRequireProofKey(true); // Force PKCE
        ResponseClient response = clientService.createAuthorizationCodeClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Create Normal Authorization Code Client
    @PostMapping("/normal-auth")
    public ResponseEntity<ResponseClient> createNormalAuthClient(
            @Valid @RequestBody AuthorizationCodeRequest request) {
        request.setAuthCodeType("normal");
        ResponseClient response = clientService.createAuthorizationCodeClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Create Client Credentials Client
    @PostMapping("/client-credentials")
    public ResponseEntity<ResponseClient> createClientCredentialsClient(
            @Valid @RequestBody ClientCredentialsRequest request) {
        ResponseClient response = clientService.createClientCredentialsClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}