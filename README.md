
```markdown
# QA Testing Project

Этот проект содержит тесты для веб-приложений с использованием **Selenium** и **TestNG** для автоматизации тестирования функционала.

## Настройка проекта

1. Клонируйте репозиторий:

   ```bash
   git clone https://github.com/DanLip02/QA_.git
   cd your-repository-folder
   ```

2. Убедитесь, что у вас установлен Maven. Для этого выполните команду:

   ```bash
   mvn -v
   ```

3. Установите все зависимости:

   ```bash
   mvn clean install
   ```

## Запуск тестов

### Запуск всех тестов через Maven

Для запуска всех тестов в проекте используйте следующую команду:

```bash
mvn test
```

### Запуск конкретного теста

Чтобы запустить конкретный тест с использованием TestNG, используйте следующую команду:

```bash
mvn -Dtest=TestBuy test
```

Замените `TestBuy` на имя нужного теста, например, `Login`.

## Пример теста

Пример теста для проверки покупки товара, включающий валидацию данных карты:

```java
@Test
public void testNavigationToProduct() {
    homePage.clickOnProduct("Samsung galaxy s6");
    productPage.clickAddToCartButton();
    wait.until(ExpectedConditions.alertIsPresent()).accept();
    productPage.clickShoppingCart();
    buyCart.clickPlaceOrderButton();
    
    boolean isCardValid = isCardNumberValid(NUMBER_) && isCardMonthValid(CARD_MONTH) && isCardYearValid(CARD_YEAR);
    Assert.assertTrue(isCardValid, "Card details are not valid");

    buyCart.fillInfoPurchaseWindow(NAME_, COUNTRY_, CITY_, NUMBER_, CARD_MONTH, CARD_YEAR);
    Assert.assertTrue(buyCart.checkSuccessfulOrderIcon());
}
```

### Валидация данных карты:
- Проверка длины номера карты (должна быть равна 10 символам).
- Проверка месяца карты (должен быть в диапазоне от 1 до 12).
- Проверка года карты (должен быть меньше 100).

## Структура кода

- **HomePage.java**: Страница главной страницы, включает методы для кликов по продуктам и навигации.
- **BuyCart.java**: Страница оформления покупки, включает метод для заполнения данных заказа и проверки успешного оформления.

## Устранение ошибок

### Проблема: `java.lang.AssertionError: Expected: true, Actual: false`

Если возникает ошибка, как указано ниже, это может означать, что данные карты не проходят валидацию:

```
java.lang.AssertionError: Expected :true Actual :false
```

Для устранения этой ошибки убедитесь, что данные карты (номер, месяц, год) соответствуют ожиданиям, и соответствующие методы валидации данных работают корректно.

### Проблема: `java.lang.TimeoutException`

Если вы видите ошибку с тайм-аутом, например:

```
java.lang.TimeoutException: Expected condition failed: waiting for element to be clickable: By.id: logout2
```

Это может означать, что элемент, с которым пытаетесь взаимодействовать, не стал кликабельным в пределах отведенного времени. Увеличьте время ожидания или проверьте, существует ли элемент на странице.
