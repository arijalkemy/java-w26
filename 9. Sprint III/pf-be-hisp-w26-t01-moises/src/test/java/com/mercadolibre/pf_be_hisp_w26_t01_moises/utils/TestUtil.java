package com.mercadolibre.pf_be_hisp_w26_t01_moises.utils;

import com.mercadolibre.pf_be_hisp_w26_t01_moises.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

        // Creating Category objects
        static Category frescoCategory = new Category(1, "Fresco", "Producto fresco");
        static Category refrigeradoCategory = new Category(2, "Refrigerado", "Producto refrigerado");
        static Category congeladoCategory = new Category(3, "Congelado", "Producto congelado");

        // Creating Product objects
        static Product bananaProduct = new Product(1, "Banana", 1500.0, frescoCategory);
        static Product manzanaProduct = new Product(2, "Manzana", 200.0, frescoCategory);
        static Product carneProduct = new Product(3, "Carne", 2030.0, refrigeradoCategory);
        Product polloProduct = new Product(4, "Pollo", 150.0, refrigeradoCategory);
        Product milanesaProduct = new Product(5, "Milanesa", 1300.0, congeladoCategory);

        // Creating Role objects
        static Role adminRole = new Role(1, "Admin", "Administrador");
        static Role buyerRole = new Role(2, "Buyer", "Comprador");

        // Creating User objects
        static User juanUser = new User(1, "juan", "$2a$12$9YkEaxhuL6Jblgm8Pd.TOuaPV9BvxdoBuoY3LaUn0kcJbzSwS.aE2", adminRole,"juan@gmail.com");
        static User joaquinUser = new User(2, "joaquin", "$2a$12$9YkEaxhuL6Jblgm8Pd.TOuaPV9BvxdoBuoY3LaUn0kcJbzSwS.aE2",adminRole, "joaquin@gmail.com");
        User elianaUser = new User(3, "eliana", "$2a$12$9YkEaxhuL6Jblgm8Pd.TOuaPV9BvxdoBuoY3LaUn0kcJbzSwS.aE2", buyerRole,"eliana@gmail.com");

        // Creating Warehouse objects
        static Warehouse warehouseA = new Warehouse(1, "Warehouse A", "Cordoba", "Cordoba", juanUser);
        static Warehouse warehouseB = new Warehouse(2, "Warehouse B", "Formosa", "Formosa", joaquinUser);

        // Creating Section objects
        static Section section1 = new Section(1, warehouseA, frescoCategory, 100);
        static Section section2 = new Section(2, warehouseA, refrigeradoCategory, 50);
        Section section3 = new Section(3, warehouseA, congeladoCategory, 30);
        Section section4 = new Section(4, warehouseB, frescoCategory, 20);
        Section section5 = new Section(5, warehouseB, refrigeradoCategory, 60);
        Section section6 = new Section(6, warehouseB, congeladoCategory, 150);

        // Creating InboundOrder objects
        static InboundOrder inboundOrder1 = new InboundOrder(1, LocalDate.of(2022,10,05), section1, null);
        static InboundOrder inboundOrder2 = new InboundOrder(2, LocalDate.of(2022,10,07), section2, null);

        // Creating Batch objects
        static Batch batch1 = new Batch(1, bananaProduct, inboundOrder1, 25.0, 20.0, 100, 70, LocalDate.of(2022,10,5), LocalDateTime.of(2022,10,5,10,0), LocalDate.of(2025,04,01));
        static Batch batch2 = new Batch(2, manzanaProduct, inboundOrder1, 22.0, 18.0, 50, 50, LocalDate.of(2022,10,7), LocalDateTime.of(2022,10,7,11,0), LocalDate.of(2025,04,07));
        static Batch batch3 = new Batch(3, carneProduct, inboundOrder2, 24.0, 17.0, 50, 50, LocalDate.of(2022,10,7), LocalDateTime.of(2022,10,7,11,0), LocalDate.of(2023,04,07));
        Batch batch4 = new Batch(4, polloProduct, inboundOrder2, 21.0, 19.0, 50, 50, LocalDate.of(2022,10,7), LocalDateTime.of(2022,10,7,11,0), LocalDate.of(2023,04,07));
        static Batch batch5 = new Batch(5, bananaProduct, inboundOrder2, 24.0, 17.0, 50, 30, LocalDate.of(2022,10,7), LocalDateTime.of(2022,10,7,11,0), LocalDate.of(2025,04,20));
        Batch batch6 = new Batch(6, bananaProduct, inboundOrder2, 24.0, 17.0, 50, 12, LocalDate.of(2022,10,7), LocalDateTime.of(2022,10,7,11,0), LocalDate.of(2025,04,07));
        static Batch batch7 = new Batch(7, bananaProduct, inboundOrder1, 25.0, 20.0, 100, 0, LocalDate.of(2022,10,5), LocalDateTime.of(2022,10,5,10,0), LocalDate.of(2025,04,01));

        // Creating PurchaseOrder object
        PurchaseOrder purchaseOrder1 = new PurchaseOrder(1, LocalDate.of(2022,10,07), joaquinUser);

        // Creating OrderItem objects
        OrderItem orderItem1 = new OrderItem(1, bananaProduct,purchaseOrder1, 10);
        OrderItem orderItem2 = new OrderItem(2, manzanaProduct,purchaseOrder1,20);

        public static List<Batch>  getBatchList(){
            final List<Batch> batchList= new ArrayList<>();
            batchList.add(batch1);
            batchList.add(batch5);
            return batchList;
        }

        public static List<Batch>  getBatchListNoStock(){
                final List<Batch> batchList= new ArrayList<>();
                batchList.add(batch7);
                return batchList;
        }

        public static List<Warehouse> getTwoWarehouses(){
                final List<Warehouse> warehouseList= new ArrayList<>();
                warehouseList.add(warehouseA);
                warehouseList.add(warehouseB);
                return warehouseList;
        }

        public static Product getbananaProduct(){
                return bananaProduct;
        }
   }
