package ru.job4j.generics;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleNameIsDirector() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Director"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Director");
    }

    @Test
    void whenAddThenRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Director"));
        store.add(new Role("2", "Analyst"));
        Role result = store.findById("2");
        assertThat(result.getRoleName()).isEqualTo("Analyst");
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsAnalyst() {
        UserStore store = new UserStore();
        store.add(new User("1", "Analyst"));
        store.add(new User("1", "Director"));
        User result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Analyst");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Analyst"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Analyst"));
        boolean result = store.replace("1", new Role("1", "Director"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Analyst"));
        boolean result = store.replace("10", new Role("1", "Director"));
        assertThat(result).isFalse();
    }
}