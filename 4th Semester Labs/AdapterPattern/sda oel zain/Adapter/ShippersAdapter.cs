using System;
namespace sda_oel_zain.Adapter
{
    public class ShippersAdapter : IShippingSystem
    {
        private readonly ThirdPartyShipper shippingSystem;

        public ShippersAdapter(ThirdPartyShipper shippingSystem)
        {
            this.shippingSystem = shippingSystem;
        }

        public void ShipOrder(string orderId, string shippingAdd)
        {
            string trackingNum = GenerateShippingLabel(orderId);

            // Ship the order using the third-party system
            shippingSystem.Ship(trackingNum, shippingAdd);
        }
        private string GenerateShippingLabel(string orderId)
        {
            // some logic for generating the shipping label
            string trackingNum = "ABC123"; // sample tracking num
            Console.WriteLine("GENERATED SHIPPING LABEL FOR ORDER {0}", orderId);
            return trackingNum;
        }
    }
}
