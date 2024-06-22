using System;
namespace sda_oel_zain.Decorator
{
    class OrderConfirmationDecorator : OrderManagerDecorator
    {
        public OrderConfirmationDecorator(IOrderManager orderManager) : base(orderManager)
        {
            //some order confirmation logic
        }
        public override void ProcessOrder(Order order)
        {
            base.ProcessOrder(order);
            Console.WriteLine("Sending order confirmation to customer: " + order.CustomerEmail);
        }
    }
}
