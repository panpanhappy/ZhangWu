package com.sjxy.view;

import com.sjxy.domain.User;
import com.sjxy.domain.ZhangWu;
import com.sjxy.service.impl.UserServiceImpl;
import com.sjxy.service.impl.ZhangwuServiceImpl;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MainView {

    // 运行程序的方法，可以启动不同的视图
    public void run() throws SQLException {
        if (loginView()) {
            // 登录成功，则进入账务管理界面
            zwManagerView();
        }
    }

    // 用户登录界面的逻辑
    private boolean loginView() {
    //输入用户密码登录
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();

        // 验证用户
        UserServiceImpl userService = new UserServiceImpl();

        User user = userService.login(username, password);

        if (user!=null) {
            // 登录成功
            System.out.println("登录成功！");
        } else {
            // 登录失败
            System.out.println("登录失败，用户名或密码错误！");
        }
        return true;
    }
//-------------------------------------------------------------

    /**
     * 账务管理视图方法，用于展示账务管理的用户界面，并提供用户进行账务操作的选项。
     *
     * @throws SQLException 如果在操作过程中数据库访问发生错误
     */
    private void zwManagerView() throws SQLException {
        System.out.println("进入账务管理页面：");
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象用于接收用户输入

        // 使用无限循环来持续接收用户输入，直到用户选择退出
        while (true) {
            System.out.println("\n请选择操作：");
            System.out.println("1. 添加账务");
            System.out.println("2. 编辑账务");
            System.out.println("3. 删除账务");
            System.out.println("4. 查询所有账务");
            System.out.println("5. 查询指定账务");
            System.out.println("6. 退出");

            int choice = scanner.nextInt(); // 接收用户输入的操作选项
            scanner.nextLine(); // 读取并忽略输入行中的剩余部分，避免nextLine()的潜在问题

            // 使用switch语句根据用户的选择执行相应的操作
            switch (choice) {
                case 1:
                    // 添加账务
                    addZhangWu(); // 调用添加账务的方法
                    break;
                case 2:
                    // 修改账务
                    modifyZhangWu(); // 调用修改账务的方法
                    break;
                case 3:
                    // 删除账务
                    deleteZhangWu(); // 调用删除账务的方法
                    break;
                case 4:
                    // 展示所有账务
                    showAllZhangWu(); // 调用展示所有账务的方法
                    break;
                case 5:
                    // 输入账务号查询账务
                    getZhangWuById(); // 调用根据账务号查询账务的方法
                    break;
                case 6:
                    // 退出
                    System.out.println("Bye~~Bye~~。"); // 提示用户退出
                    scanner.close(); // 关闭Scanner对象
                    return; // 退出方法
                default:
                    // 如果用户输入了无效的选择，则提示用户重新输入
                    System.out.println("无效的选择，请重新输入。");
            }
        }
    }


    /**
     * 根据账务号查询账务信息的方法。
     * 该方法首先提示用户输入要查询的账务号，然后调用服务层的方法获取对应的账务信息，
     * 最后根据获取到的账务信息打印详细信息或提示未找到账务。
     *
     */


    private void getZhangWuById() throws SQLException {
        // 创建ZhangwuServiceImpl的实例，用于调用服务层的方法
        ZhangwuServiceImpl zhangWuService = new ZhangwuServiceImpl();
        // 创建Scanner对象用于接收用户从控制台输入的账务号
        Scanner scanner = new Scanner(System.in);
        // 提示用户输入要查询的账务号
        System.out.println("输入你要查询的账务号：");
        // 接收用户输入的账务号
        int id = scanner.nextInt();
        // 读取并忽略输入行中的剩余部分（通常是换行符），以避免在后续读取时出现问题
        scanner.nextLine();
        // 调用服务层的方法，根据输入的账务号查询账务信息
        ZhangWu zhangWu = zhangWuService.getZhangWuById(id);
        // 判断查询结果是否为空
        if (zhangWu != null) {
            // 如果找到了账务，则打印该账务的详细信息
            System.out.println("账务信息:");
            // 使用String.format格式化账务信息并打印
            // 这里假设ZhangWu类有getZwid(), getFlname(), getMoney(), getZhangHu(), getCreatetime(), getDescription()等方法
            System.out.println(String.format("ID: %d, 分类名称: %s, 金额: %.2f, 账户: %s, 创建时间: %s, 描述: %s",
                    zhangWu.getZwid(),  // 账务ID
                    zhangWu.getFlname(),  // 分类名称
                    zhangWu.getMoney(),  // 金额
                    zhangWu.getZhangHu(),  // 账户
                    zhangWu.getCreatetime(),  // 创建时间
                    zhangWu.getDescription()));  // 描述
        } else {
            // 如果没有找到对应的账务，则提示用户
            System.out.println("没找到该账务");
        }


    }


    //------------------------------------------------------------
    //展示所有账务
    private void showAllZhangWu() throws SQLException {
        // 创建ZhangwuServiceImpl的实例，用于调用服务层的方法
        ZhangwuServiceImpl zhangWuService = new ZhangwuServiceImpl();
        // 调用服务层的方法获取所有账务的列表
        List<ZhangWu> zhangWuList = zhangWuService.getAllZhangWu();

        // 遍历账务列表，并打印每个账务的详细信息
        // 注意：这里假设ZhangWu类重写了toString()方法以提供有意义的字符串表示
        for (ZhangWu zhangWu : zhangWuList) {
            System.out.println(zhangWu);
        }
    }

    //修改账务
    private void modifyZhangWu() throws SQLException {
        // 创建Scanner对象用于接收用户从控制台输入的信息
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入要修改的账务号
        System.out.println("输入你要修改的账务号：");
        int id = scanner.nextInt();
        // 读取并忽略输入行中的剩余部分（通常是换行符）
        scanner.nextLine();

        // 创建ZhangwuServiceImpl的实例，用于调用服务层的方法
        ZhangwuServiceImpl zhangWuService = new ZhangwuServiceImpl();
        // 根据输入的账务号查询对应的账务信息
        ZhangWu zhangWu = zhangWuService.getZhangWuById(id);

        // 判断是否找到了对应的账务
        if (zhangWu == null) {
            System.out.println("未找到对应的账务信息！");
            // 如果没有找到，则直接返回
            return;
        }

        // 提示用户输入新的分类名称，并更新账务信息
        System.out.println("输入新的分类名称：");
        String newFlname = scanner.nextLine();
        zhangWu.setFlname(newFlname);

        // 提示用户输入新的金额，并更新账务信息
        // 注意：这里需要处理double的输入，并且可能需要处理输入验证
        System.out.println("输入新的金额：");
        double newMoney = scanner.nextDouble();
        // 读取并忽略输入行中的剩余部分（可能是换行符或额外的输入）
        scanner.nextLine();
        zhangWu.setMoney(newMoney);

        // 提示用户输入新的账户，并更新账务信息
        System.out.println("输入新的账户：");
        String newZhanghu = scanner.nextLine();
        zhangWu.setZhangHu(newZhanghu);

        // 提示用户输入新的日期，并更新账务信息
        // 注意：这里假设日期是以字符串形式输入的，实际应用中可能需要更复杂的日期处理
        System.out.println("输入新的日期：");
        String newCreateTime = scanner.nextLine();
        zhangWu.setCreatetime(newCreateTime);

        System.out.println("输入新的描述：");
        String newDescription = scanner.nextLine();
        zhangWu.setDescription(newDescription);

        //调用修改账务的方法，传入你想要修改的ID
        zhangWuService.modifyZhangWu(id);

        //打印结果
        zhangWuService.getZhangWuById(id);
    }

    /*-----------------------------------------------------------------------*/

    //添加账务
    /**
     * 添加新的账务信息。
     *
     * 该方法通过控制台输入的方式收集账务的详细信息，包括分类名称、金额、账户、日期和描述，
     * 然后将这些信息封装到一个ZhangWu对象中，并调用服务层的addZhangWu方法将新的账务信息保存到数据库中。
     *
     * @throws SQLException 如果在数据库操作过程中发生SQL异常，则抛出此异常。
     */
    private void addZhangWu() throws SQLException {

        // 创建ZhangwuServiceImpl的实例，用于执行数据库操作
        ZhangwuServiceImpl zhangWuService = new ZhangwuServiceImpl();

        // 创建一个新的ZhangWu对象，用于存储用户输入的账务信息
        ZhangWu zhangWu = new ZhangWu();

        // 创建一个Scanner对象，用于从控制台读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 请求用户输入分类名称，并设置到zhangWu对象中
        System.out.println("输入分类名称：");
        String newFlname = scanner.nextLine();
        zhangWu.setFlname(newFlname);

        // 请求用户输入金额，并设置到zhangWu对象中
        System.out.println("输入金额：");
        double newMoney = scanner.nextDouble();
        zhangWu.setMoney(newMoney);
        // 消耗掉nextLine()之前的换行符
        scanner.nextLine();

        // 请求用户输入账户，并设置到zhangWu对象中
        System.out.println("输入账户：");
        String newZhanghu = scanner.nextLine();
        zhangWu.setZhangHu(newZhanghu);

        // 请求用户输入日期，并设置到zhangWu对象中
        System.out.println("输入日期：");
        String newCreateTime = scanner.nextLine();
        zhangWu.setCreatetime(newCreateTime);

        // 请求用户输入描述，并设置到zhangWu对象中
        System.out.println("输入描述：");
        String newDescription = scanner.nextLine();
        zhangWu.setDescription(newDescription);

        // 调用服务层的addZhangWu方法，将新的账务信息保存到数据库中
        zhangWuService.addZhangWu(zhangWu);

        // 关闭Scanner对象（可选，但在此场景中JVM退出时会自动关闭）
        // scanner.close();
    }

    /**
     * 删除指定的账务信息。
     *
     * 该方法首先通过控制台输入的方式获取用户想要删除的账务的ID，然后调用服务层的deleteZhangWu方法，
     * 将指定ID的账务信息从数据库中删除。
     *
     * @throws SQLException 如果在数据库操作过程中发生SQL异常，则抛出此异常。
     */
    private void deleteZhangWu() throws SQLException {
        // 创建一个Scanner对象，用于从控制台读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入要删除的账务号
        System.out.println("输入你要删除的账务号：");

        // 读取用户输入的账务号ID
        int id = scanner.nextInt();

        // 消耗掉nextInt()之后的换行符，避免影响后续的nextLine()调用
        scanner.nextLine();

        // 创建ZhangwuServiceImpl的实例，用于执行数据库操作
        ZhangwuServiceImpl zhangwuService = new ZhangwuServiceImpl();

        // 调用服务层的deleteZhangWu方法，传入用户想要删除的账务ID
        zhangwuService.deleteZhangWu(id);

        // 注意：这里没有显式关闭Scanner对象，因为JVM在退出时会自动关闭所有资源。
        // 如果Scanner是扫描文件或其他非系统资源的，那么关闭它就是必需的。
    }


}