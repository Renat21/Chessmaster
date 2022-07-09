package ru.chess.chessmaster.repository;

import org.springframework.data.repository.CrudRepository;
import ru.chess.chessmaster.entity.ConfirmationToken;


public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}