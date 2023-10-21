package gigio.dev.santanderdevweek2023.service;

import gigio.dev.santanderdevweek2023.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
