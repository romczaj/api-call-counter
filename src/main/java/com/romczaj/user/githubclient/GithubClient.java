package com.romczaj.user.githubclient;

import com.romczaj.exception.FailedOperation;
import io.vavr.control.Either;

public interface GithubClient {
    Either<FailedOperation, UserApiGithubResponse> findUser(String login);
}
