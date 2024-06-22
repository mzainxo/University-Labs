using System;
namespace sda_oel_zain.Decorator
{
    class OrderManager : IOrderManager
    {
        public void ProcessOrder(Order order)
        {
            // some logic for processing the order
            Console.WriteLine("Processing order: " + order.OrderId);
        }
    }
}
