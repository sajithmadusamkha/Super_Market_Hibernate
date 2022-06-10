import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class AppInitializer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName("Samson");
        c1.setSalary(200000);
        c1.setAddress("New York");

        Customer c2 = new Customer();
        c2.setId("C002");
        c2.setName("Rock Dwayne");
        c2.setSalary(100000);
        c2.setAddress("Sidney");

        Item i1 = new Item();
        i1.setItemCode("I003");
        i1.setDescription("Iphone x");
        i1.setQtyOnHand(50);
        i1.setUnitPrice(600);

/*        Item i2 = new Item();
        i1.setItemCode("I002");
        i1.setDescription("Iphone xs");
        i1.setQtyOnHand(50);
        i1.setUnitPrice(600);*/

        Order o1 = new Order();
        o1.setCustomer("Samson");
        o1.setTotal(150000);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setId("M001");
        orderDetail1.setOrder(o1);
        orderDetail1.setItem(i1);
        orderDetail1.setQty(1);
        orderDetail1.setSubTotal(150000);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        o1.addOrderDetail(orderDetail1);

        session.save(o1);
        //session.save(c2);

        //session.update(c2);
        //Customer c3 = session.get(Customer.class, "C002");
        //System.out.println(c3.getName());

        //Customer c3 = new Customer();
        //c3.setId("C002");
        //session.delete(c3);
        transaction.commit();
        session.close();
    }
}
