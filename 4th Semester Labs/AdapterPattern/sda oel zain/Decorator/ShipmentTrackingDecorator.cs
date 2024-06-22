using System;
namespace sda_oel_zain.Decorator
{
    class ShipmentTrackingDecorator : OrderManagerDecorator
    {
        public ShipmentTrackingDecorator(IOrderManager orderManager) : base(orderManager)
        {
        }
        public override void ProcessOrder(Order order)
        {
            base.ProcessOrder(order);
            Console.WriteLine("Sending shipment tracking number to customer: " + order.CustomerEmail);
        }
    }
}
