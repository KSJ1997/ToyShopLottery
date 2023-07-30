package src.main.java;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        ToyShopLotteryManager lotteryManager = new ToyShopLotteryManager(toyShop, "src/main/resources/PrizeLog.txt");


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
    }
}