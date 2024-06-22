using sda_oel_zain.Adapter;
using System;
namespace sda_oel_zain
{
    class Program
    {
        static void Main(string[] args)
        {
            ThirdPartyShipper thirdPartySys = new ThirdPartyShipper();

            // creating shipping system adapter
            IShippingSystem shippingSystem = new ShippersAdapter(thirdPartySys);

            // shipping an order example
            string orderId = "123";
            string shippingAdd = "123 Street, Karachi, Pakistan";
            shippingSystem.ShipOrder(orderId, shippingAdd);

            Console.ReadLine();
        }
    }
}
