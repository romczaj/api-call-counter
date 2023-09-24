package com.romczaj.user.githubclient;

import com.romczaj.exception.FailedOperation;
import io.vavr.control.Either;
import io.vavr.control.Option;
import java.time.Instant;
import java.util.Map;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import static com.romczaj.exception.FailedOperationCode.LOGIN_NOT_FOUND;

@Component
@ConditionalOnMissingBean(PhysicalGithubClient.class)
public class MockGithubClient implements GithubClient {

    private static final Map<String, UserApiGithubResponse> DATABASE =
        Map.of("octocat", new UserApiGithubResponse(
            "octocat",
            111111,
            "The Octocat",
            "user",
            "https://mock.com/avatar/octocat",
            Instant.now(),
            9,
            8));

    @Override
    public Either<FailedOperation, UserApiGithubResponse> findUser(String login) {
        return Option.of(DATABASE.get(login)).toEither(() -> new FailedOperation(LOGIN_NOT_FOUND));
    }
}
