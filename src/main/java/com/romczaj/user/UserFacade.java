package com.romczaj.user;

import com.romczaj.exception.FailedOperationException;
import com.romczaj.user.githubclient.GithubClient;
import com.romczaj.user.githubclient.UserApiGithubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final GithubClient githubClient;

    public UserApiResponse findUser(String login) {
        return githubClient.findUser(login)
            .map(this::toUserApiResponse)
            .getOrElseThrow(FailedOperationException::new);
    }

    private UserApiResponse toUserApiResponse(UserApiGithubResponse userApiGithubResponse) {
        return new UserApiResponse(
            userApiGithubResponse.id(),
            userApiGithubResponse.login(),
            userApiGithubResponse.name(),
            userApiGithubResponse.type(),
            userApiGithubResponse.avatarUrl(),
            userApiGithubResponse.createdAt(),
            CalculationsUtil.countUserData(userApiGithubResponse.followers(), userApiGithubResponse.publicRepos())
        );
    }

}