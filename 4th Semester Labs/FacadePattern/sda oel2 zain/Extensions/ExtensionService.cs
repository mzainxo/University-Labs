using System;
namespace sda_oel2_zain.Extensions
{
    public class ExtensionService
    {
        public ExtensionService() 
        {
            var GoogleMaps = new ThirdpartyApp();
            ISystemData systemData = new SystemDataAdapter(GoogleMaps);
            systemData.ProvidePublicData();
        }
    }
}
