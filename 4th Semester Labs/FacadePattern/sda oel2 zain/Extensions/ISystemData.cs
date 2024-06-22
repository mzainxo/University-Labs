using System;
namespace sda_oel2_zain.Extensions
{
    public interface ISystemData
    {
        void ProvidePublicData();
    }
    public class SystemData : ISystemData
    {
        public void ProvidePublicData()
        {
            //implementation
        }
    }

    public class SystemDataAdapter : ISystemData
    {
        private ThirdpartyApp thirdPartyApp;

        public SystemDataAdapter(ThirdpartyApp GoogleMaps)
        {
            this.thirdPartyApp = GoogleMaps;
        }

        public void ProvidePublicData()
        {
            Console.WriteLine("Providing Public Data for StoreJinnie");
            thirdPartyApp.UseSystemData();
        }
    }
}
