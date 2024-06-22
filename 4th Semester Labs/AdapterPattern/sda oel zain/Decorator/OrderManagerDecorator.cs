using System;
namespace sda_oel_zain.Decorator
{
    public abstract class OrderManagerDecorator: IOrderManager
    {
        private readonly IOrderManager orManager;

        public OrderManagerDecorator(IOrderManager orderManager)
        {
            orManager = orderManager;
        }
        public virtual void ProcessOrder(Order order)
        {
            orManager.ProcessOrder(order);
        }
    }
}
