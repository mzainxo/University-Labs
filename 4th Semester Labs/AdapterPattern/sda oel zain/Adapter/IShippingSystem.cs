using System;
namespace sda_oel_zain.Adapter
{
    public interface IShippingSystem
    {
        void ShipOrder(string orderId, string shippingAddress);
    }
}
