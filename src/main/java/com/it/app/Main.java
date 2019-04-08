package com.it.app;

import com.it.app.config.AppConfiguration;
import com.it.app.model.Flat;
import com.it.app.model.User;
import com.it.app.model.UserRole;
import com.it.app.repository.FlatRepository;
import com.it.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Main {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlatRepository flatRepository;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotatedClassApplicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Main main = annotatedClassApplicationContext.getBean("main", Main.class);
        //Создаем новый объект user1 - запись в таблице user
        User user1 = new User();
        // определяем имя для user1
        user1.setName("Helen");
        //сохраняем сведения в таблице
        main.getUserRepository().save(user1);
        //находим в таблице user человека по id  и выводим его на экран
        Optional<User> one = main.getUserRepository().findById(1L);
        System.out.println("===============№1===============");
        one.ifPresent(System.out::println);
        //удаляем эту запись из таблицы user
        one.ifPresent(main.getUserRepository()::delete);
        //опять пытаемся найти этого же человека и выводим результат на экран (существует ли он?)
        one = main.getUserRepository().findById(1L);
        System.out.println("===============№2===============");
        System.out.println(one.isPresent());
        //аналогично создаем нового userа и выодим его по id
        User user = new User();
        user.setName("Vova");
        main.getUserRepository().save(user);
        Optional<User> three = main.getUserRepository().findById(2L);
        System.out.println("===============№3===============");
        three.ifPresent(System.out::println);
        //меняем имя этого userа на имя Mike
        user.setName("Mike");
        //сохраняем и обновляем его и выводим на экран опять по id
        main.getUserRepository().saveAndFlush(user);
        three = main.getUserRepository().findById(2L);
        three.ifPresent(System.out::println);
        //находим в таблице и выводим на экран информацию о usere c именем Mike
        Optional<User> four = main.getUserRepository().findByName("Mike");
        System.out.println("===============№4===============");
        four.ifPresent(System.out::println);
        //находим общее количество userов в таблице
        System.out.println("===============№5===============");
        System.out.println("The count of users is = " + main.getUserRepository().findCountOfUsers());
        //удаляем все сведения из таблицы User
        main.getUserRepository().deleteAll();
        //Добавляем в таблицу Flat  квартиру со значениями: 4 комнаты, адрес-Тавлая, цена - 50000
        Flat flat = new Flat();
        flat.setNumberRooms(4L);
        flat.setAdress("Tavlaya street, 44");
        flat.setValue(50000L);
        //Сохраняем запись в таблице
        main.getFlatRepository().save(flat);
        //находим запись в таблице Flat по значению id=1;
        Optional<Flat> flat1 = main.getFlatRepository().findById(1L);
        //Выводим сохраненую квартиру на консоль, если такая существует
        System.out.println("===============№6===============");
        flat1.ifPresent(System.out::println);
        //Добавляем в таблицу Flat  квартиру со значениями 2 комнаты, адрес-БЛК, цена - 35000
        Flat flat2 = new Flat();
        flat2.setNumberRooms(2L);
        flat2.setAdress("BLK, 44");
        flat2.setValue(35000L);
        //Сохраняем запись в таблице
        main.getFlatRepository().save(flat2);
        //находим запись в таблице Flat по значению id=2;
        Optional<Flat> flat3 = main.getFlatRepository().findById(2L);
        //Выводим сохраненую квартиру на консоль, если такая существует
        System.out.println("===============№7===============");
        flat3.ifPresent(System.out::println);
        System.out.println("===============№8===============");
        //Находим и распечатываем из имеющихся данных в таблице максимальное значение стоимости квартиры
        System.out.println("Max value of flat is = " + main.getFlatRepository().findMaxValue());
        //отсортировываем по количеству комнат и выводим все квартиры в таблице Flat в порядке возрастания
        List<Flat> flatAll = main.getFlatRepository().findAllFlats(Sort.by("numberRooms"));
        System.out.println("===============№9===============");
        System.out.println(flatAll);
        //удаляем все записи
        main.getFlatRepository().deleteAll();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FlatRepository getFlatRepository() {
        return flatRepository;
    }

    public void setFlatRepository(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }
}