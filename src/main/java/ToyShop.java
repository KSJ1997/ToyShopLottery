package src.main.java;
import java.util.ArrayList;
import java.util.List;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void updateToyProbability(int toyId, double newProbability) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setProbability(newProbability);
                return;
            }
        }
        System.out.println("Ошибка: Игрушка с ID " + toyId + " не найдена.");
    }

    public Toy drawPrizeToy() {
        double totalProbability = toys.stream().mapToDouble(Toy::getProbability).sum();
        if (totalProbability <= 0) {
            System.out.println("Ошибка: Вероятности всех игрушек равны нулю или отрицательны.");
            return null;
        }

        double randomValue = Math.random() * totalProbability;
        double currentProbability = 0.0;

        for (Toy toy : toys) {
            currentProbability += toy.getProbability();
            if (randomValue <= currentProbability && toy.getQuantity() > 0) {
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getProbability());
                toy.setQuantity(toy.getQuantity() - 1);
                return prizeToy;
            }
        }

        // Если все игрушки закончились, вернуть null
        return null;
    }
}