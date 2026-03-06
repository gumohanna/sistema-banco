package model.service;

public interface TaxService {

    default Double withDraw(Double amount, Double balance){
        if (amount > balance && balance < 0){
            throw new IllegalArgumentException("Seu saldo deve ser maior que o valor do saque ou/e não pode ser negativo!");

        } else if (amount < 1500.00 ){
            return balance - amount * (2.5 / 100);

        } else if (amount > 1500.00 && amount < 3000.00) {
            return balance - amount * (5 / 100);

        }else return balance - amount * (10 / 100);
    }
}
