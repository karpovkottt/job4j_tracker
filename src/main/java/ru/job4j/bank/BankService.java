package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса с различными действиями:
 * - добавление пользователя
 * - удаление пользователя
 * - добавление банковского счета пользователю
 * - перевод средств с одного счета на другой
 * @author Konstantin Karpov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных пользователей и привязанных к ним счетов осуществляется
     * в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход данные пользователя (объект класса User) и если в
     * коллекции такого пользователя нет, добавляет его с пустым списком счетов.
     * @param user объект класса User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта и удаляет пользователя с данным
     * паспортом из коллекции
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход номер паспорта и счет, который необходимо добавить
     * в список счетов пользователя. Метод осуществляет проверку существования
     * пользователя и что в списке аккаунтов не содержится данного номера счета
     * @param passport номер паспорта пользователя
     * @param account объект класса Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает на вход номер паспорта и осуществляет поиск пользователя с данным
     * номером паспорта по коллекции
     * @param passport номер паспорта пользователя
     * @return возвращает объект класса User или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта и номер счета пользователя и осуществляет
     * поиск данного счета у пользователя.
     * @param passport номер паспорта пользователя
     * @param requisite номер счета пользователя
     * @return возвращает объект класса Account с номером счета и балансом или null
     * если пользователь или номер счета не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            for (Account acc : list) {
                if (requisite.equals(acc.getRequisite())) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта и номер счета отправителя, также
     * номер паспорта и номер счета получателя, и сумму перевода. Метод осуществляет
     * перевод суммы со счета отправителя на счет получателя.
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод осуществлен или false если счет не найден
     * или не достаточно средств на счете отправителя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                               && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает на вход объект класса User и возвращает список счетов пользователя
     * @param user объект класса User
     * @return возвращает список объектов класса Account(список счетов пользователя)
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
