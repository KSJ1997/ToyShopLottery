package src.test.java;
import java.util.List;

import src.main.java.Toy;
import src.main.java.ToyShop;
import src.main.java.ToyShopLotteryManager;

public class ToyShopLotteryTest {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        ToyShopLotteryManager lotteryManager = new ToyShopLotteryManager(toyShop, "src/test/resources/TestLog.txt");

        Toy toy1 = new Toy(1, "Кукла", 10, 50.0);
        Toy toy2 = new Toy(2, "Мяч", 15, 30.0);
        Toy toy3 = new Toy(3, "Машинка", 20, 20.0);

        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);

        toyShop.updateToyProbability(1, 60.0);

        int numberOfPrizes = 3;
        lotteryManager.performLottery(numberOfPrizes);

        lotteryManager.displayPrizeToys();

        // После розыгрыша можно также вывести оставшиеся игрушки в магазине
        System.out.println("Оставшиеся игрушки в магазине:");
        List<Toy> remainingToys = toyShop.getToys();
        for (Toy toy : remainingToys) {
            System.out.println(toy);
        }
    }
}