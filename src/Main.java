public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
    }

    public static void ex1() {

        //Дана строка
        String name = "     ПЕтРов Олег Иванович     ";
        //Необходимо
        //1. убрать лишние пробелы,
        name = name.trim();

        //2. перевести текст в верхний регистр
        name = name.toUpperCase();

        //3. Если содержит "ова " то печатаем на экран: Уважаемая {name}
        // Если содержит "ов " то печатаем на экран: Уважаемый {name}
        // В иных случаях печатаем на экран: Неизвестное лицо {name}
        if (name.contains("ова") || name.contains("ОВА")){
            System.out.println("Уважаемая "+name);
        } else if (name.contains("ов") || name.contains("ОВ")) {
            System.out.println("Уважаемый "+name);
        }else {
            System.out.println("Неизвестное лицо "+name);
        }

    }

    public static void ex2() {
        //У нас есть машина. В данной машине есть перечень проверок, перед запуском
        //Количество топлива
        double fuel = 10;
        //Проверка двигателя
        boolean isEngineWork = true;
        //Проверка отсутствия ошибок (false - ошибок нет)
        boolean hasErrors = false;
        //Датчики давления шин
        boolean isWheelWork1 = true;
        boolean isWheelWork2 = true;
        boolean isWheelWork3 = true;
        boolean isWheelWork4 = true;

        //Поменять(убрать, поставить) логические операторы так, чтобы машина запускалась:
        // когда топлива не меньше 10 литров, двигатель работает, колеса все работают, нет ошибок
        //В ином случае, машина не должна запускаться
        if (
                fuel >= 10
                        && isEngineWork
                        &&  (isWheelWork1 && isWheelWork2 && isWheelWork3 && isWheelWork4)
                        && !hasErrors

        ) {
            System.out.println("Машина работает");
        } else {
            System.out.println("Машина не работает");
        }
    }

    public static void ex3() {

        //Заменить в строке все 'this is' на 'those are', получить индекс (число) второй буквы 'o' в строке
        //Распечатать полученный индекс
        String simply = "this is simply. This is my favorite song.";
        simply = simply.replace("this is","those are");
        int index = simply.indexOf('o') + 1;
        System.out.println(simply.substring(index,simply.length()).indexOf('o') + 1 + index);
    }

    public static void ex4() {
        //Компания Рога и Копыта производит мясные продукты.
        //Перечень производимых товаров :
        //Колбаса - стоимость 800 руб,
        //себестоимость при производстве меньше 1000 кг - 412руб,
        //себестоимость при производстве от 1000 до 2000 (не включая) - 408 руб
        //себестоимость при производстве от 2000кг - 404 руб

        //Ветчина - стоимость 350 руб
        //себестоимость при производстве - 275 руб

        //Шейка - стоимость 500 руб
        //себестоимость при производстве меньше 500кг - 311 руб
        //себестоимость при производстве больше или равно 500кг - 299 руб

        //Финансовые показатели
        //Доход компании считается как умножение стоимости на количество проданных кг
        //Расход компании считается как умножение себестоимости на количество проданных кг + миллион рублей
        //Прибыль до налогов считается как: доход - расход
        //Налоги считаются так:
        // прибыль до налогов больше 2_000_000, облагается ставкой 13%
        // прибыль до налогов больше 1_000_000 от 2_000_000, облагается ставкой 10%
        // прибыль до налогов меньше 1_000_000, облагается ставкой 8%
        //пример расчета налогов для прибыли до налогов 2_500_000:
        //1_000_000 - налог 80_000 - по ставке 8%
        //1_000_000 - налог 100_000 - по ставке 10%
        //500_000 - 65_000 - по ставке 13%
        //Итоговый налог: 80_000 + 100_000 + 65_000 = 245_000
        //Прибыль после налогов: прибыль до налогов - налог.

        //Необходимо создать универсальную систему расчетов прибыли после налогов,
        //Т.е на вход подаются данные по количеству произведенных продуктов
        // и печатается прибыль после налогов компании
        //Узнать прибыль после налогов, при продаже:
        //Колбасы 2000кг
        //Ветчины 8511кг
        //Шейки 6988кг
        profitAfterTaxes("Колбаса",800, 2000);
        profitAfterTaxes("Ветчина",350, 8511);
        profitAfterTaxes("Шейка",500, 6988);
    }

    //Прибыль после налогов
    public static void profitAfterTaxes(String name, int coast, int volume){
        int costPrice = costPrice(name, volume);
        int income = income(coast, volume);
        int consumption =consumption(costPrice, volume);
        int profitBeforeTaxes = profitBeforeTaxes(income,consumption);
        double profit = taxes(profitBeforeTaxes);
        System.out.println("Прибыль после налогов, при продаже " + name + ": "
                +((profitBeforeTaxes-profit)>0?((profitBeforeTaxes-profit) + " руб"):("Прибыль отсутствует, расходы: "+
                profitBeforeTaxes+" руб")));

    }
    //Себестоимость
    public static int costPrice(String name, int volume){
        int price=0;
        if (name.equalsIgnoreCase("Колбаса")){
            if (volume < 1000){
                price = 412;
            } else if (volume >= 1000 && volume < 2000){
                price = 408;
            } else if (volume >= 2000) {
                price = 404;
            }
        } else if (name.equalsIgnoreCase("Ветчина")) {
            price = 275;
        } else if (name.equalsIgnoreCase("Шейка")) {
            if (volume < 500){
                price = 311;
            } else if (volume >= 500) {
                price = 299;
            }
        }else {
            System.out.println("Нет такого товара в ассортименте производства");
            price = 0;
        }
        return price;
    }
    //Доход
    public static int income(int coast, int countProduct){
        return coast * countProduct;
    }
    //Расход
    public static int consumption(int costPrice, int countProduct){
        return (costPrice * countProduct) + 1000_000;
    }
    //Прибыль до налогов
    public static int profitBeforeTaxes(int income, int consumption){
        return income - consumption;
    }
    //Налог
    public static double taxes(int profit){
        if (profit < 0){
            return 0;
        }
        double taxes=0.0;
        if (profit < 1000_000){
            taxes = profit * 0.08;
        }
        if (profit >= 1000_000 && profit <= 2000_000){
            taxes = (profit * 0.08) + (profit * 0.1);
        }
        if (profit > 2000_000){
            taxes = (profit * 0.08) + (profit * 0.1) + (profit - 2000_000) * 0.13;
        }
        return taxes;
    }
}
