import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    @Test
    public void RemoveWhenProductExists() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 5);
        Product product2 = new Product(2, "Мука", 6);
        Product product3 = new Product(3, "Молоко", 7);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveWhenProductNotExists() {

        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Хлеб", 5);
        Product product2 = new Product(2, "Мука", 6);
        Product product3 = new Product(3, "Молоко", 7);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.remove(3456)
        );
    }

}
