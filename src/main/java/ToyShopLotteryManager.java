package src.main.java;
import java.util.ArrayList;
import java.util.List;

public class ToyShopLotteryManager {
    private ToyShop toyShop;
    private List<Toy> prizeToys;
    private PrizeLogWriter prizeLogWriter;

    public ToyShopLotteryManager(ToyShop toyShop, String prizeLogFilePath) {
        this.toyShop = toyShop;
        prizeToys = new ArrayList<>();
        prizeLogWriter = new PrizeLogWriter(prizeLogFilePath);
    }

    public void performLottery(int numberOfPrizes) {
        for (int i = 0; i < numberOfPrizes; i++) {
            Toy prizeToy = toyShop.drawPrizeToy();
            if (prizeToy != null) {
                prizeToys.add(prizeToy);
            } else {
                System.out.println("Ошибка: Все игрушки закончились. Розыгрыш завершен.");
                break;
            }
        }
        prizeLogWriter.writePrizeLog(prizeToys);
    }
    

    public void displayPrizeToys() {
        System.out.println("Призовые игрушки:");
        for (Toy toy : prizeToys) {
            System.out.println(toy);
        }
    }
}
