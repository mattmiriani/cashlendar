package com.matt.cashlendar.entrypoint;

import com.matt.cashlendar.core.entity.ClientEntity;
import com.matt.cashlendar.core.usecase.ClientUseCase;
import com.matt.cashlendar.entrypoint.entity.ClientRequestHttpModel;
import com.matt.cashlendar.entrypoint.mapper.ClientRequestHttpModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientEntrypoint {

    private ClientUseCase clientUseCase;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody ClientRequestHttpModel clientRequestHttpModel) {
        ClientEntity clientEntity = ClientRequestHttpModelMapper.from(clientRequestHttpModel);
        ClientEntity client = clientUseCase.create(clientEntity);

        return ResponseEntity.ok().body(ClientRequestHttpModelMapper.to(client));
    }
}
