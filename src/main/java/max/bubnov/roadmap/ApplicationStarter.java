package max.bubnov.roadmap;

import max.bubnov.roadmap.controller.MainController;
import max.bubnov.roadmap.domain.City;
import max.bubnov.roadmap.domain.Road;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationStarter {
    public static void main(String[] args) throws IOException {

        MainController controller = new MainController();

        List<City> cities;
        List<Road> roads;

        System.out.println("Сервис RoadMap." +
                "API" +
                "\n 1. Добавление нового города" +
                "\n 2. Добавление новой дороги" +
                "\n 3. Соедениние двух городов дорогой" +
                "\n 4. Получение города по имени" +
                "\n 5. Получение списка дорог по имени города" +
                "\n 6. Удаление дороги" +
                "\n 0. Выход из программы" +
                "\n Чтобы начать работу - Введите соответсвующую цифру API");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int count = Integer.parseInt(reader.readLine());

            //Добавление нового Города
            if (count == 1) {

                while (true) {
                    System.out.println("Добавьте город в следующем формате (без фигурных скобок) {имя, координата Х, координата У} пример: Пермь 1 -5");
                    String city = reader.readLine();

                    if (city.equals("\\q")) {
                        break;
                    } else {
                        String[] citiesInfo = city.split(" ");
                        if(citiesInfo.length != 3) {
                            System.out.println("Неверный ввод");
                        }
                        if(controller.createCity(new City(
                                citiesInfo[0],
                                Integer.parseInt(citiesInfo[1]),
                                Integer.parseInt(citiesInfo[2])))) {
                            System.out.println("Город успешно добавлен");
                        } else {
                            System.out.println("Такой город уже существует");
                        }
                        System.out.println("Если желаете закончить ввод Городов - введите в консоль \\q");
                    }
                }
                cities = controller.getAllCities();
                System.out.println("Список Городов:");
                System.out.println(cities);
                System.out.println("Выберите следующий номер API");

            } else if (count == 2) {
                //Добавление новой дороги
                while (true) {
                    System.out.println("Добавьте дорогу в следующем формате (без фигурных скобок) {имя, длина} пример: Е105 25");
                    String road = reader.readLine();

                    if (road.equals("\\q")) {
                        break;
                    } else {
                        String[] roadInfo = road.split(" ");
                        if(controller.createRoad(new Road(roadInfo[0], Integer.parseInt(roadInfo[1])))) {
                            System.out.println("Дорога успешно добавлена");
                        } else {
                            System.out.println("Такая дорога уже существует!");
                        }
                        System.out.println("Если желаете закончить ввод Дорог - введите в консоль \\q");
                    }
                }
                roads = controller.getAllRoads();
                System.out.println("Список Дорог:");
                System.out.println(roads);
                System.out.println("Выберите следующий номер API");
            } else if(count == 3) {
                //Соедениние двух городов дорогой
                while (true) {
                    System.out.println("Соедените два города дорогой в следующем формате: " +
                            "\n(без фигурных скобок) {город1, город2, дорога} " +
                            "\nпример: Москва Питер Р25");
                    String cityRoad = reader.readLine();

                    if (cityRoad.equals("\\q")) {
                        break;
                    } else {
                        String[] roadMap = cityRoad.split(" ");

                        City first = controller.getCityByName(roadMap[0]);
                        City second = controller.getCityByName(roadMap[1]);
                        Road road = controller.getRoadByName(roadMap[2]);

                        if (controller.addRoad(first, second, road)) {
                            System.out.println("Дорога добавлена");
                        } else {
                            System.out.println("Возникла ошибка");
                        }

                        System.out.println("Если желаете закончить ввод - введите в консоль \\q");
                    }
                    System.out.println("Выберите следующий номер API");
                }
            } else if (count == 4) {
                //Получение города по имени
                while (true) {
                    System.out.println("Введите название города, который хотите найти");
                    String city = reader.readLine();

                    if (city.equals("\\q")) {
                        break;
                    } else {
                        System.out.println(controller.getCityByName(city));
                    }
                }
                System.out.println("Выберите следующий номер API");
            } else if (count == 5) {
                //Получение списка дорог по имени города
                while (true) {
                    System.out.println("Введите название Города, для получения списка дорог");
                    String town = reader.readLine();

                    if (town.equals("\\q")) {
                        break;
                    } else {
                        System.out.println(controller.getRoadsByCityName(town));
                    }
                }
                System.out.println("Выберите следующий номер API");
            } else if(count == 6) {

                //Удаление дороги
                while (true) {
                    System.out.println("Введите имя Дороги, которую хотите удалить");
                    String roadDel = reader.readLine();

                    if(roadDel.equals("\\q")) {
                        break;
                    } else {
                        controller.deleteRoad(controller.getRoadByName(roadDel));
                    }
                }
                System.out.println("Выберите следующий номер API");

            } else if(count == 0) {
                //Выход из программы
                System.exit(0);
            } else if(count == 7) {

                //Проверка, что дорога удалена действительно
                while (true) {
                    System.out.println("Введите имя Дороги, которую хотите просмотреть");
                    String road = reader.readLine();

                    if(road.equals("\\q")) {
                        break;
                    } else {
                        System.out.println(controller.getRoadByName(road));
                        System.out.println(controller.getAllRoads());
                    }
                }
                System.out.println("Выберите следующий номер API");
            }
        }
    }
}
