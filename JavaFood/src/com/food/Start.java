package com.food;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Start {


    public static void main(String[] args) {
        /**
         * 课程设计
         * 功能模块
         * 1膨化食品 PuffedFood
         * 2肉类食品 MeatFood
         * 3甜点类食品 DessertFood
         * 4乳制品类食品 DairyFood
         *
         * */
        // 入口
        mainPage();
    }
/**
 * 主菜单mainPage()
 * */
    public static void mainPage() {
        System.out.println("***********************\n");
        System.out.println("\t 1.进入食品类型选择\n");
        System.out.println("***********************\n");
        System.out.println("\n请输入选项，或者按0退出。");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-1]"; // 正则表达式
            if (choice.matches(regex)) { // 判断是否与regex匹配
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        System.out.println("----------------");
                        System.out.println("您已经退出系统");
                        System.exit(1);
                        break;
                    case 1: //进入食品类型选择
                        System.out.println("您已经进入食品类型选择");
                        foodType();
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
            System.err.println("输入有误!");
            System.out.println("重新选择或按0退出");
        } while (true);
    }
/**
 * 种类菜单foodType()
 * */
    private static void foodType() {
        System.out.println("***********************\n");
        System.out.println("请选择要操作的食品类型：");
        System.out.println("1.膨化食品");
        System.out.println("2.肉类食品");
        System.out.println("3.甜点类食品");
        System.out.println("4.乳制品类食品");
        System.out.println("***********************\n");
        System.out.println("\n请输入选项，或者按0返回上一级菜单.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-4]";
            if (choice.matches(regex)) { // 判断是否与regex匹配
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        mainPage();
                        break;
                    case 1:
                        // 膨化食品
                        System.out.println("---->进入膨化类食品菜单");
                        puffedFoodMenu();  // 调用膨化食品菜单
                        break;
                    case 2:
                        // 肉类食品
                        System.out.println("---->进入肉类食品菜单");
                        meatFoodMenu();// 调用肉食品菜单
                        break;
                    case 3:
                        // 甜点类食品
                        System.out.println("---->进入甜点类食品菜单");
                        dessertFoodMenu();
                        break;
                    case 4:
                        // 乳制品类食品
                        System.out.println("---->进入乳制品类食品菜单");
                        dairyFoodMenu();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("输入有误!");
            System.out.println("重新选择或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 膨化食品Menu
     */
    private static void puffedFoodMenu() {
        do {
            System.out.println("***********************\n");
            System.out.println("膨化食品菜单：");
            System.out.println("1. 查看单个膨化食品");
            System.out.println("2. 添加膨化食品");
            System.out.println("3. 修改膨化食品");
            System.out.println("4. 删除膨化食品");
            System.out.println("5. 查看全部膨化食品");
            System.out.println("***********************\n");
            System.out.println("\n请输入选项，或者按0返回上一级菜单.");

            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        foodType();
                        return;
                    case 1:
                        // 查看膨化食品
                        System.out.println("---->查看单个膨化食品");
                        // 提示用户输入要查看的膨化食品名称或ID
                        System.out.println("请输入要查看的膨化食品ID:");
                        String foodIdentifier = ScannerChoice.scannerInfoString();

                        // 从数据库中查询膨化食品数据
                        Object puffedFoodToView = retrievePuffedFoodFromDatabase(foodIdentifier);

                        if (puffedFoodToView != null) {
                            // 显示膨化食品信息
                            System.out.println("膨化食品信息：");
                            System.out.println(puffedFoodToView.toString());
                        } else {
                            System.out.println("未找到该膨化食品.");
                        }

                        break;
                    case 2:
                        // 添加膨化食品
                        System.out.println("---->添加膨化食品");
                        // 提示用户输入膨化食品信息
                        System.out.println("请输入膨化食品ID：");
                        String foodId= ScannerChoice.scannerInfoString();
                        System.out.println("请输入膨化食品名称：");
                        String foodName = ScannerChoice.scannerInfoString();
                        System.out.println("请输入膨化食品价格：");
                        double foodPrice = ScannerChoice.scannerInfoDouble();
                        System.out.println("请输入膨化食品类型：");
                        String foodType = ScannerChoice.scannerInfoString();
                        // 插入膨化食品信息到数据库
                        boolean success = addPuffedFoodToDatabase(foodId,foodName, foodPrice, foodType);
                        if (success) {
                            System.out.println("膨化食品添加成功！");
                        } else {
                            System.out.println("膨化食品添加失败！");
                        }
                        break;

                    case 3:
                        // 修改膨化食品
                        System.out.println("---->修改膨化食品");

                        // 提示用户输入要修改的膨化食品的标识符（如 FOOD_ID）
                        System.out.println("请输入要修改的膨化食品的标识符（FOOD_ID ）:");
                        String foodIdentifier1 = ScannerChoice.scannerInfoString();

                        // 提示用户输入新的膨化食品信息
                        System.out.println("请输入新的膨化食品名称:");
                        String newFoodName = ScannerChoice.scannerInfoString();

                        System.out.println("请输入新的膨化食品价格:");
                        double newFoodPrice = ScannerChoice.scannerInfoDouble();

                        System.out.println("请输入新的膨化食品类型:");
                        String newFoodType = ScannerChoice.scannerInfoString();

                        // 调用更新膨化食品信息的方法
                        boolean updateSuccess = updatePuffedFoodInDatabase(foodIdentifier1, newFoodName, newFoodPrice, newFoodType);

                        if (updateSuccess) {
                            System.out.println("膨化食品信息修改成功！");
                        } else {
                            System.err.println("膨化食品信息修改失败！");
                        }
                        break;

                    case 4:
                        // 删除膨化食品
                        System.out.println("---->删除膨化食品");

                        // 提示用户输入要删除的膨化食品的 FOOD_ID
                        System.out.println("请输入要删除的膨化食品的 FOOD_ID:");
                        int foodIdToDelete = ScannerChoice.scannerInfoInt();

                        // 调用删除膨化食品的方法
                        boolean deleteSuccess = deletePuffedFoodFromDatabase(foodIdToDelete);

                        if (deleteSuccess) {
                            System.out.println("膨化食品删除成功！");
                        } else {
                            System.err.println("膨化食品删除失败！");
                        }

                        break;
                    case 5:
                        // 查看全部膨化食品
                        System.out.println("---->查看全部膨化食品");

                        // 调用查询全部膨化食品的方法
                        retrieveAllPuffedFoodFromDatabase();

                        break;

                    default:
                        System.err.println("输入有误!");
                        break;
                }
            }

            System.out.println("重新选择或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 肉类食品Menu
     */
    private static void meatFoodMenu() {
        do {
            System.out.println("***********************\n");
            System.out.println("肉类食品菜单：");
            System.out.println("1. 查看单个肉类食品");
            System.out.println("2. 添加肉类食品");
            System.out.println("3. 修改肉类食品");
            System.out.println("4. 删除肉类食品");
            System.out.println("5. 查看全部肉类食品");
            System.out.println("***********************\n");
            System.out.println("\n请输入选项，或者按0返回上一级菜单.");

            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        foodType();
                        return;
                    case 1:
                        // 查看肉类食品
                        System.out.println("---->查看单个肉类食品");
                        // 提示用户输入要查看的肉类食品ID
                        System.out.println("请输入要查看的肉类食品ID:");
                        String foodIdentifier = ScannerChoice.scannerInfoString();

                        // 从数据库中查询肉类食品数据
                        Object meatFoodToView = retrieveMeatFoodFromDatabase(foodIdentifier);

                        if (meatFoodToView != null) {
                            // 显示肉类食品信息
                            System.out.println("肉类食品信息：");
                            System.out.println(meatFoodToView.toString());
                        } else {
                            System.out.println("未找到该肉类食品.");
                        }

                        break;
                    case 2:
                        // 添加肉类食品
                        System.out.println("---->添加肉类食品");

                        // 提示用户输入肉类食品信息
                        System.out.println("请输入肉类食品ID：");
                        String foodId = ScannerChoice.scannerInfoString();
                        System.out.println("请输入肉类食品名称：");
                        String foodName = ScannerChoice.scannerInfoString();
                        System.out.println("请输入肉类食品价格：");
                        double foodPrice = ScannerChoice.scannerInfoDouble();
                        System.out.println("请输入肉类食品类型：");
                        String foodType = "2"; // 肉类食品类型为2

                        // 插入肉类食品信息到数据库
                        boolean success = addMeatFoodToDatabase(foodId, foodName, foodPrice, foodType);

                        if (success) {
                            System.out.println("肉类食品添加成功！");
                        } else {
                            System.out.println("肉类食品添加失败！");
                        }
                        break;

                    case 3:
                        // 修改肉类食品
                        System.out.println("---->修改肉类食品");

                        // 提示用户输入要修改的肉类食品的标识符（如 FOOD_ID）
                        System.out.println("请输入要修改的肉类食品的标识符（FOOD_ID ）:");
                        String foodIdentifier1 = ScannerChoice.scannerInfoString();

                        // 提示用户输入新的肉类食品信息
                        System.out.println("请输入新的肉类食品名称:");
                        String newFoodName = ScannerChoice.scannerInfoString();

                        System.out.println("请输入新的肉类食品价格:");
                        double newFoodPrice = ScannerChoice.scannerInfoDouble();

                        // 调用更新肉类食品信息的方法
                        boolean updateSuccess = updateMeatFoodInDatabase(foodIdentifier1, newFoodName, newFoodPrice);

                        if (updateSuccess) {
                            System.out.println("肉类食品信息修改成功！");
                        } else {
                            System.err.println("肉类食品信息修改失败！");
                        }
                        break;

                    case 4:
                        // 删除肉类食品
                        System.out.println("---->删除肉类食品");

                        // 提示用户输入要删除的肉类食品的 FOOD_ID
                        System.out.println("请输入要删除的肉类食品的 FOOD_ID:");
                        int foodIdToDelete = ScannerChoice.scannerInfoInt();

                        // 调用删除肉类食品的方法
                        boolean deleteSuccess = deleteMeatFoodFromDatabase(foodIdToDelete);

                        if (deleteSuccess) {
                            System.out.println("肉类食品删除成功！");
                        } else {
                            System.err.println("肉类食品删除失败！");
                        }

                        break;
                    case 5:
                        // 查看全部肉类食品
                        System.out.println("---->查看全部肉类食品");

                        // 调用查询全部肉类食品的方法
                        retrieveAllMeatFoodFromDatabase();

                        break;

                    default:
                        System.err.println("输入有误!");
                        break;
                }
            }

            System.out.println("重新选择或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 甜品类食品Menu
     */
    private static void dessertFoodMenu() {
        do {
            System.out.println("***********************\n");
            System.out.println("甜品类食品菜单：");
            System.out.println("1. 查看单个甜品类食品");
            System.out.println("2. 添加甜品类食品");
            System.out.println("3. 修改甜品类食品");
            System.out.println("4. 删除甜品类食品");
            System.out.println("5. 查看全部甜品类食品");
            System.out.println("***********************\n");
            System.out.println("\n请输入选项，或者按0返回上一级菜单.");

            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        foodType();
                        return;
                    case 1:
                        // 查看甜品类食品
                        System.out.println("---->查看单个甜品类食品");
                        // 提示用户输入要查看的甜品类食品ID
                        System.out.println("请输入要查看的甜品类食品ID:");
                        String foodIdentifier = ScannerChoice.scannerInfoString();

                        // 从数据库中查询甜品类食品数据
                        Object dessertFoodToView = retrieveDessertFromDatabase(foodIdentifier);

                        if (dessertFoodToView != null) {
                            // 显示甜品类食品信息
                            System.out.println("甜品类食品信息：");
                            System.out.println(dessertFoodToView.toString());
                        } else {
                            System.out.println("未找到该甜品类食品.");
                        }

                        break;
                    case 2:
                        // 添加甜品类食品
                        System.out.println("---->添加甜品类食品");

                        // 提示用户输入甜品类食品信息
                        System.out.println("请输入甜品类食品ID：");
                        String foodId = ScannerChoice.scannerInfoString();
                        System.out.println("请输入甜品类食品名称：");
                        String foodName = ScannerChoice.scannerInfoString();
                        System.out.println("请输入甜品类食品价格：");
                        double foodPrice = ScannerChoice.scannerInfoDouble();
                        System.out.println("请输入甜品类食品类型：");
                        String foodType = ScannerChoice.scannerInfoString();

                        // 插入甜品类食品信息到数据库
                        boolean success = addDessertToDatabase(foodId, foodName, foodPrice, foodType);

                        if (success) {
                            System.out.println("甜品类食品添加成功！");
                        } else {
                            System.out.println("甜品类食品添加失败！");
                        }
                        break;

                    case 3:
                        // 修改甜品类食品
                        System.out.println("---->修改甜品类食品");

                        // 提示用户输入要修改的甜品类食品的标识符（如 FOOD_ID）
                        System.out.println("请输入要修改的甜品类食品的标识符（FOOD_ID ）:");
                        String foodIdentifier1 = ScannerChoice.scannerInfoString();

                        // 提示用户输入新的甜品类食品信息
                        System.out.println("请输入新的甜品类食品名称:");
                        String newFoodName = ScannerChoice.scannerInfoString();

                        System.out.println("请输入新的甜品类食品价格:");
                        double newFoodPrice = ScannerChoice.scannerInfoDouble();

                        System.out.println("请输入新的甜品类食品类型:");
                        String newFoodType = ScannerChoice.scannerInfoString();

                        // 调用更新甜品类食品信息的方法
                        boolean updateSuccess = updateDessertInDatabase(foodIdentifier1,newFoodName,newFoodPrice);

                        if (updateSuccess) {
                            System.out.println("甜品类食品信息修改成功！");
                        } else {
                            System.err.println("甜品类食品信息修改失败！");
                        }
                        break;

                    case 4:
                        // 删除甜品类食品
                        System.out.println("---->删除甜品类食品");

                        // 提示用户输入要删除的甜品类食品的 FOOD_ID
                        System.out.println("请输入要删除的甜品类食品的 FOOD_ID:");
                        int foodIdToDelete = ScannerChoice.scannerInfoInt();

                        // 调用删除甜品类食品的方法
                        boolean deleteSuccess = deleteDessertFromDatabase(foodIdToDelete);

                        if (deleteSuccess) {
                            System.out.println("甜品类食品删除成功！");
                        } else {
                            System.err.println("甜品类食品删除失败！");
                        }

                        break;
                    case 5:
                        // 查看全部甜品类食品
                        System.out.println("---->查看全部甜品类食品");

                        // 调用查询全部甜品类食品的方法
                        retrieveAllDessertFromDatabase();

                        break;

                    default:
                        System.err.println("输入有误!");
                        break;
                }
            }

            System.out.println("重新选择或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 乳制品类食品Menu
     */
    private static void dairyFoodMenu() {
        do {
            System.out.println("***********************\n");
            System.out.println("乳制品类食品菜单：");
            System.out.println("1. 查看单个乳制品类食品");
            System.out.println("2. 添加乳制品类食品");
            System.out.println("3. 修改乳制品类食品");
            System.out.println("4. 删除乳制品类食品");
            System.out.println("5. 查看全部乳制品类食品");
            System.out.println("***********************\n");
            System.out.println("\n请输入选项，或者按0返回上一级菜单.");

            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        foodType();
                        return;
                    case 1:
                        // 查看乳制品类食品
                        System.out.println("---->查看单个乳制品类食品");
                        // 提示用户输入要查看的乳制品类食品ID
                        System.out.println("请输入要查看的乳制品类食品ID:");
                        String foodIdentifier = ScannerChoice.scannerInfoString();

                        // 从数据库中查询乳制品类食品数据
                        Object dairyFoodToView = retrieveDairyFoodFromDatabase(foodIdentifier);

                        if (dairyFoodToView != null) {
                            // 显示乳制品类食品信息
                            System.out.println("乳制品类食品信息：");
                            System.out.println(dairyFoodToView.toString());
                        } else {
                            System.out.println("未找到该乳制品类食品.");
                        }

                        break;
                    case 2:
                        // 添加乳制品类食品
                        System.out.println("---->添加乳制品类食品");

                        // 提示用户输入乳制品类食品信息
                        System.out.println("请输入乳制品类食品ID：");
                        String foodId = ScannerChoice.scannerInfoString();
                        System.out.println("请输入乳制品类食品名称：");
                        String foodName = ScannerChoice.scannerInfoString();
                        System.out.println("请输入乳制品类食品价格：");
                        double foodPrice = ScannerChoice.scannerInfoDouble();
                        System.out.println("请输入乳制品类食品类型：");
                        String foodType = ScannerChoice.scannerInfoString();

                        // 插入乳制品类食品信息到数据库
                        boolean success = addDairyFoodToDatabase(foodId, foodName, foodPrice, foodType);

                        if (success) {
                            System.out.println("乳制品类食品添加成功！");
                        } else {
                            System.out.println("乳制品类食品添加失败！");
                        }
                        break;

                    case 3:
                        // 修改乳制品类食品
                        System.out.println("---->修改乳制品类食品");

                        // 提示用户输入要修改的乳制品类食品的标识符（如 FOOD_ID）
                        System.out.println("请输入要修改的乳制品类食品的标识符（FOOD_ID ）:");
                        String foodIdentifier1 = ScannerChoice.scannerInfoString();

                        // 提示用户输入新的乳制品类食品信息
                        System.out.println("请输入新的乳制品类食品名称:");
                        String newFoodName = ScannerChoice.scannerInfoString();

                        System.out.println("请输入新的乳制品类食品价格:");
                        double newFoodPrice = ScannerChoice.scannerInfoDouble();

                        System.out.println("请输入新的乳制品类食品类型:");
                        String newFoodType = ScannerChoice.scannerInfoString();

                        // 调用更新乳制品类食品信息的方法
                        boolean updateSuccess = updateDairyFoodInDatabase(foodIdentifier1, newFoodName, newFoodPrice);


                        if (updateSuccess) {
                            System.out.println("乳制品类食品信息修改成功！");
                        } else {
                            System.err.println("乳制品类食品信息修改失败！");
                        }
                        break;

                    case 4:
                        // 删除乳制品类食品
                        System.out.println("---->删除乳制品类食品");

                        // 提示用户输入要删除的乳制品类食品的 FOOD_ID
                        System.out.println("请输入要删除的乳制品类食品的 FOOD_ID:");
                        int foodIdToDelete = ScannerChoice.scannerInfoInt();

                        // 调用删除乳制品类食品的方法
                        boolean deleteSuccess = deleteDairyFoodFromDatabase(foodIdToDelete);

                        if (deleteSuccess) {
                            System.out.println("乳制品类食品删除成功！");
                        } else {
                            System.err.println("乳制品类食品删除失败！");
                        }

                        break;
                    case 5:
                        // 查看全部乳制品类食品
                        System.out.println("---->查看全部乳制品类食品");

                        // 调用查询全部乳制品类食品的方法
                        retrieveAllDairyFoodFromDatabase();

                        break;

                    default:
                        System.err.println("输入有误!");
                        break;
                }
            }

            System.out.println("重新选择或按0返回上一级菜单");
        } while (true);
    }

    /**
     * 实现从数据库中检索膨化食品数据的方法
     * */
    private static Object retrievePuffedFoodFromDatabase(String foodName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 1";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodName);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 从结果集中获取膨化食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String retrievedFoodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int retrievedFoodType = resultSet.getInt("FOOD_TYPE");

                // 创建一个包含膨化食品信息的Map，也可以使用其他数据结构
                Map<String, Object> puffedFoodMap = new HashMap<>();
                puffedFoodMap.put("FOOD_ID", foodId);
                puffedFoodMap.put("FOOD_NAME", retrievedFoodName);
                puffedFoodMap.put("FOOD_PRICE", foodPrice);
                puffedFoodMap.put("FOOD_TYPE", retrievedFoodType);

                return puffedFoodMap;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    //插入
    private static boolean addPuffedFoodToDatabase(String foodId, String foodName, double foodPrice, String foodType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备插入语句，为 FOOD_ID 设置值
            String sql = "INSERT INTO FOOD_TABLE (FOOD_ID, FOOD_NAME, FOOD_PRICE, FOOD_TYPE) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodId);
            preparedStatement.setString(2, foodName);
            preparedStatement.setDouble(3, foodPrice);
            preparedStatement.setString(4, foodType);

            // 执行插入
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //修改
    private static boolean updatePuffedFoodInDatabase(String foodIdentifier, String newFoodName, double newFoodPrice, String newFoodType) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        // 加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 建立数据库连接
        connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

        // 准备更新语句
        String sql = "UPDATE FOOD_TABLE SET FOOD_NAME = ?, FOOD_PRICE = ?, FOOD_TYPE = ? WHERE FOOD_ID = ? ";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newFoodName);
        preparedStatement.setDouble(2, newFoodPrice);
        preparedStatement.setString(3, newFoodType);
        preparedStatement.setString(4, foodIdentifier);

        // 执行更新
        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        // 关闭资源
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    // 在 Start 类中添加删除膨化食品的方法
    private static boolean deletePuffedFoodFromDatabase(int foodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备删除语句
            String sql = "DELETE FROM FOOD_TABLE WHERE FOOD_ID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, foodId);

            // 执行删除
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //查看全部
    private static void retrieveAllPuffedFoodFromDatabase() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        // 加载数据库驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 建立数据库连接
        connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

        // 准备查询语句
        String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_TYPE = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "1");  // Assuming 1 represents PuffedFood in your FOOD_TYPE column

        // 执行查询
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // 从结果集中获取膨化食品信息
            int foodId = resultSet.getInt("FOOD_ID");
            String foodName = resultSet.getString("FOOD_NAME");
            double foodPrice = resultSet.getDouble("FOOD_PRICE");
            String foodType = resultSet.getString("FOOD_TYPE");

            // 输出食品信息或根据需要进行其他处理
            System.out.println("食品ID: " + foodId);
            System.out.println("食品名称: " + foodName);
            System.out.println("食品价格: " + foodPrice);
            System.out.println("食品类型: " + foodType);
            System.out.println("------------------------");
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        // 关闭资源
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    /**
     * 实现从数据库中检索肉类食品数据的方法
     */
    private static Object retrieveMeatFoodFromDatabase(String foodIdentifier) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 2";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodIdentifier);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 从结果集中获取肉类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String retrievedFoodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int retrievedFoodType = resultSet.getInt("FOOD_TYPE");

                // 创建一个包含肉类食品信息的Map，也可以使用其他数据结构
                Map<String, Object> meatFoodMap = new HashMap<>();
                meatFoodMap.put("FOOD_ID", foodId);
                meatFoodMap.put("FOOD_NAME", retrievedFoodName);
                meatFoodMap.put("FOOD_PRICE", foodPrice);
                meatFoodMap.put("FOOD_TYPE", retrievedFoodType);

                return meatFoodMap;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 插入肉类食品信息到数据库
     */
    private static boolean addMeatFoodToDatabase(String foodId, String foodName, double foodPrice, String foodType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备插入语句，为 FOOD_ID 设置值
            String sql = "INSERT INTO FOOD_TABLE (FOOD_ID, FOOD_NAME, FOOD_PRICE, FOOD_TYPE) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodId);
            preparedStatement.setString(2, foodName);
            preparedStatement.setDouble(3, foodPrice);
            preparedStatement.setString(4, foodType);

            // 执行插入
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新肉类食品信息的方法
     */
    private static boolean updateMeatFoodInDatabase(String foodIdentifier, String newFoodName, double newFoodPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备更新语句
            String sql = "UPDATE FOOD_TABLE SET FOOD_NAME = ?, FOOD_PRICE = ? WHERE FOOD_ID = ? AND FOOD_TYPE = 2";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFoodName);
            preparedStatement.setDouble(2, newFoodPrice);
            preparedStatement.setString(3, foodIdentifier);

            // 执行更新
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除肉类食品信息的方法
     */
    private static boolean deleteMeatFoodFromDatabase(int foodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备删除语句
            String sql = "DELETE FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 2";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, foodId);

            // 执行删除
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询并输出全部肉类食品信息的方法
     */
    private static void retrieveAllMeatFoodFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_TYPE = 2";
            preparedStatement = connection.prepareStatement(sql);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 从结果集中获取肉类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String foodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int foodType = resultSet.getInt("FOOD_TYPE");

                // 输出食品信息或根据需要进行其他处理
                System.out.println("食品ID: " + foodId);
                System.out.println("食品名称: " + foodName);
                System.out.println("食品价格: " + foodPrice);
                System.out.println("食品类型: " + foodType);
                System.out.println("------------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现从数据库中检索甜品类食品数据的方法
     */
    private static Object retrieveDessertFromDatabase(String foodIdentifier) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 3";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodIdentifier);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 从结果集中获取甜品类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String retrievedFoodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int retrievedFoodType = resultSet.getInt("FOOD_TYPE");

                // 创建一个包含甜品类食品信息的Map，也可以使用其他数据结构
                Map<String, Object> dessertFoodMap = new HashMap<>();
                dessertFoodMap.put("FOOD_ID", foodId);
                dessertFoodMap.put("FOOD_NAME", retrievedFoodName);
                dessertFoodMap.put("FOOD_PRICE", foodPrice);
                dessertFoodMap.put("FOOD_TYPE", retrievedFoodType);

                return dessertFoodMap;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 插入甜品类食品信息到数据库
     */
    private static boolean addDessertToDatabase(String foodId, String foodName, double foodPrice, String foodType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备插入语句，为 FOOD_ID 设置值
            String sql = "INSERT INTO FOOD_TABLE (FOOD_ID, FOOD_NAME, FOOD_PRICE, FOOD_TYPE) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodId);
            preparedStatement.setString(2, foodName);
            preparedStatement.setDouble(3, foodPrice);
            preparedStatement.setString(4, foodType);

            // 执行插入
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新甜品类食品信息的方法
     */
    private static boolean updateDessertInDatabase(String foodIdentifier, String newFoodName, double newFoodPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备更新语句
            String sql = "UPDATE FOOD_TABLE SET FOOD_NAME = ?, FOOD_PRICE = ? WHERE FOOD_ID = ? AND FOOD_TYPE = 3";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFoodName);
            preparedStatement.setDouble(2, newFoodPrice);
            preparedStatement.setString(3, foodIdentifier);

            // 执行更新
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除甜品类食品信息的方法
     */
    private static boolean deleteDessertFromDatabase(int foodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备删除语句
            String sql = "DELETE FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 3";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, foodId);

            // 执行删除
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询并输出全部甜品类食品信息的方法
     */
    private static void retrieveAllDessertFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_TYPE = 3";
            preparedStatement = connection.prepareStatement(sql);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 从结果集中获取甜品类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String foodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int foodType = resultSet.getInt("FOOD_TYPE");

                // 输出食品信息或根据需要进行其他处理
                System.out.println("食品ID: " + foodId);
                System.out.println("食品名称: " + foodName);
                System.out.println("食品价格: " + foodPrice);
                System.out.println("食品类型: " + foodType);
                System.out.println("------------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 实现从数据库中检索乳制品类食品数据的方法
     */
    private static Object retrieveDairyFoodFromDatabase(String foodIdentifier) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 4";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodIdentifier);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 从结果集中获取乳制品类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String retrievedFoodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int retrievedFoodType = resultSet.getInt("FOOD_TYPE");

                // 创建一个包含乳制品类食品信息的Map，也可以使用其他数据结构
                Map<String, Object> dairyFoodMap = new HashMap<>();
                dairyFoodMap.put("FOOD_ID", foodId);
                dairyFoodMap.put("FOOD_NAME", retrievedFoodName);
                dairyFoodMap.put("FOOD_PRICE", foodPrice);
                dairyFoodMap.put("FOOD_TYPE", retrievedFoodType);

                return dairyFoodMap;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 插入乳制品类食品信息到数据库
     */
    private static boolean addDairyFoodToDatabase(String foodId, String foodName, double foodPrice, String foodType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备插入语句，为 FOOD_ID 设置值
            String sql = "INSERT INTO FOOD_TABLE (FOOD_ID, FOOD_NAME, FOOD_PRICE, FOOD_TYPE) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, foodId);
            preparedStatement.setString(2, foodName);
            preparedStatement.setDouble(3, foodPrice);
            preparedStatement.setString(4, foodType);

            // 执行插入
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新乳制品类食品信息的方法
     */
    private static boolean updateDairyFoodInDatabase(String foodIdentifier, String newFoodName, double newFoodPrice) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备更新语句
            String sql = "UPDATE FOOD_TABLE SET FOOD_NAME = ?, FOOD_PRICE = ? WHERE FOOD_ID = ? AND FOOD_TYPE = 4";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFoodName);
            preparedStatement.setDouble(2, newFoodPrice);
            preparedStatement.setString(3, foodIdentifier);

            // 执行更新
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 删除乳制品类食品信息的方法
     */
    private static boolean deleteDairyFoodFromDatabase(int foodId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备删除语句
            String sql = "DELETE FROM FOOD_TABLE WHERE FOOD_ID = ? AND FOOD_TYPE = 4";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, foodId);

            // 执行删除
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // 关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询并输出全部乳制品类食品信息的方法
     */
    private static void retrieveAllDairyFoodFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载数据库驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 建立数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-O8QMVOC:1521:stu", "system", "Orcle123");

            // 准备查询语句
            String sql = "SELECT * FROM FOOD_TABLE WHERE FOOD_TYPE = 4";
            preparedStatement = connection.prepareStatement(sql);

            // 执行查询
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // 从结果集中获取乳制品类食品信息
                int foodId = resultSet.getInt("FOOD_ID");
                String foodName = resultSet.getString("FOOD_NAME");
                double foodPrice = resultSet.getDouble("FOOD_PRICE");
                int foodType = resultSet.getInt("FOOD_TYPE");

                // 输出食品信息或根据需要进行其他处理
                System.out.println("食品ID: " + foodId);
                System.out.println("食品名称: " + foodName);
                System.out.println("食品价格: " + foodPrice);
                System.out.println("食品类型: " + foodType);
                System.out.println("------------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}