package com.matt.cashlendar.entrypoint;

import com.matt.cashlendar.core.usecase.SecurityUseCase;
import com.matt.cashlendar.entrypoint.entity.LoginRequestHttpModel;
import com.matt.cashlendar.entrypoint.entity.RegisterRequestHttpModel;
import com.matt.cashlendar.entrypoint.mapper.LoginRequestHttpModelMapper;
import com.matt.cashlendar.entrypoint.mapper.RegisterRequestHttpModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityEntrypoint {

    private SecurityUseCase securityUseCase;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestHttpModel loginRequestHttpModel) {
        String token = securityUseCase.login(loginRequestHttpModel.getUsername(), loginRequestHttpModel.getPassword());

        return ResponseEntity.ok().body(
                LoginRequestHttpModel.builder()
                        .username(loginRequestHttpModel.getUsername())
                        .token(token)
                        .build()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestHttpModel registerRequestHttpModel) {
        LoginRequestHttpModel clientRequestHttpModel = LoginRequestHttpModelMapper
                .to(securityUseCase.register(RegisterRequestHttpModelMapper.from(registerRequestHttpModel)), "a");

        return ResponseEntity.ok().body(clientRequestHttpModel);
    }
}
