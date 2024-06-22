using System;
using System.Collections.Generic;
using System.Text;

namespace sda_oel2_zain.Affiliation
{
    public class AffiliateProgramService
    {
        public AffiliateProgramService() 
        {
            var affiliateProgram = new AffiliateProgram();
            var affiliatePortal = new AffiliatePortal(affiliateProgram);
            var marketingDataProcessor = new MarketingDataProcessor(affiliateProgram);

            AffiliateData data = new AffiliateData();
            affiliateProgram.Notify(data);
        }
    }
}
