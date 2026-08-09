namespace hellmath {

// TODO: Task 1 - Define an `AccountStatus` enumeration to represent the four
// account types: `troll`, `guest`, `user`, and `mod`.
enum class AccountStatus {
    troll,
    guest,
    user,
    mod,
};

// TODO: Task 1 - Define an `Action` enumeration to represent the three
// permission types: `read`, `write`, and `remove`.
enum class Action {
    read,
    write,
    remove,
};

// TODO: Task 2 - Implement the `display_post` function, that gets two arguments
// of `AccountStatus` and returns a `bool`. The first argument is the status of
// the poster, the second one is the status of the viewer.
bool display_post(AccountStatus poster_status, AccountStatus viewer_status) {
    if(poster_status == AccountStatus::troll) {
        if(viewer_status == AccountStatus::troll) {
            return true;
        }
        return false;
    }
    return true;
}

// TODO: Task 3 - Implement the `permission_check` function, that takes an
// `Action` as a first argument and an `AccountStatus` to check against. It
// should return a `bool`.
bool permission_check(Action action, AccountStatus status) {
    switch(action) {
        case Action::remove:
            if(status == AccountStatus::mod) {
                return true;
            }
            return false;
        case Action::write:
            if(status == AccountStatus::guest) {
                return false;
            }
            return true;
        default:
            return true;
    }
}

// TODO: Task 4 - Implement the `valid_player_combination` function that
// checks if two players can join the same game. The function has two parameters
// of type `AccountStatus` and returns a `bool`.
bool valid_player_combination(AccountStatus player1, AccountStatus player2) {
    switch (player1) {
        case AccountStatus::guest:
            return false;
        case AccountStatus::troll:
            if(player2 != AccountStatus::troll) {
                return false;
            }
            return true;
        case AccountStatus::mod:
        case AccountStatus::user:
            if(player2 == AccountStatus::troll || player2 == AccountStatus::guest) {
                return false;
            }
    }
    return true;
}

// TODO: Task 5 - Implement the `has_priority` function that takes two
// `AccountStatus` arguments and returns `true`, if and only if the first
// account has a strictly higher priority than the second.
bool has_priority(AccountStatus player1, AccountStatus player2) {
    return player1 > player2;
  }
}  // namespace hellmath
