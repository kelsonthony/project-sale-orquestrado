package com.kelsonthony.payment.application.core.usecase;

import com.kelsonthony.payment.application.core.domain.User;
import com.kelsonthony.payment.application.ports.in.FindUserByIdInputPort;
import com.kelsonthony.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }
}
