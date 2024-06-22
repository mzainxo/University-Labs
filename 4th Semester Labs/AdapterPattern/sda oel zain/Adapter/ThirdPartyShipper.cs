using System;
namespace sda_oel_zain.Adapter
{
    public class ThirdPartyShipper
    {
        public void Ship(string trackingNumber, string address)
        {
            // some logic for shipping using the third-party shipping system
            Console.WriteLine("Shipping order {0} to {1} via third-party shippers", trackingNumber, address);
        }
    }
}
