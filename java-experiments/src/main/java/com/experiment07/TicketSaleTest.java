package com.experiment07;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 车票类
class Ticket {

    public Ticket(int id, String startStation, String endStation) {
    }

    // Getters and Setters...
}

// 铁道部类，管理车票
class RailwayDepartment {
    private AtomicInteger ticketsLeft = new AtomicInteger(200);
    private List<Ticket> tickets = new ArrayList<>();

    public RailwayDepartment() {
        for (int i = 0; i < 200; i++) {
            tickets.add(new Ticket(i, "哈尔滨", "北京"));
        }
    }

    // 同步方法，确保线程安全
    public synchronized boolean getTicket(TicketSalePoint salePoint) {
        if (ticketsLeft.get() > 0) {
            Ticket ticket = tickets.remove(ticketsLeft.decrementAndGet());
            salePoint.sellTicket(ticket);
            return true;
        }
        return false;
    }
}

// 售票点类
class TicketSalePoint {
    private String name;
    List<Ticket> soldTickets = new ArrayList<>();

    public TicketSalePoint(String name) {
        this.name = name;
    }

    public void sellTicket(Ticket ticket) {
        soldTickets.add(ticket);
    }

    // 模拟其他业务逻辑操作
    public void doOtherBusiness() {
        try {
            Thread.sleep((long) (Math.random() * 50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 测试类
public class TicketSaleTest {

    public static void main(String[] args) {
        RailwayDepartment railwayDepartment = new RailwayDepartment();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        TicketSalePoint salePoint1 = new TicketSalePoint("售票点1");
        TicketSalePoint salePoint2 = new TicketSalePoint("售票点2");
        TicketSalePoint salePoint3 = new TicketSalePoint("售票点3");

        for (int i = 0; i < 200; i++) {
            executor.execute(() -> {
                if (railwayDepartment.getTicket(salePoint1)) {
                    salePoint1.doOtherBusiness();
                }
            });
            executor.execute(() -> {
                if (railwayDepartment.getTicket(salePoint2)) {
                    salePoint2.doOtherBusiness();
                }
            });
            executor.execute(() -> {
                if (railwayDepartment.getTicket(salePoint3)) {
                    salePoint3.doOtherBusiness();
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // 等待所有线程执行完毕
        }

        // 打印每个售票点的销售数
        System.out.println("售票点1销售数: " + salePoint1.soldTickets.size());
        System.out.println("售票点2销售数: " + salePoint2.soldTickets.size());
        System.out.println("售票点3销售数: " + salePoint3.soldTickets.size());

        // 验证总票数是否正确
        int totalSold = salePoint1.soldTickets.size() + salePoint2.soldTickets.size() + salePoint3.soldTickets.size();
        System.out.println("总票数是否正确: " + (totalSold == 200));
    }
}