using System;
namespace sda_oel2_zain.Affiliation
{
    public interface IAffiliateObserver
    {
        void Update(AffiliateData data);
    }
    public class AffiliatePortal : IAffiliateObserver
    {
        private AffiliateProgram affiliateProgram;

        public AffiliatePortal(AffiliateProgram affiliateProgram)
        {
            this.affiliateProgram = affiliateProgram;
            affiliateProgram.Attach(this);
        }

        public void Update(AffiliateData data)
        {
            Console.WriteLine("Affliate data updated at the Affiliate Portals");
        }
    }

    public class MarketingDataProcessor : IAffiliateObserver
    {
        private AffiliateProgram affiliateProgram;

        public MarketingDataProcessor(AffiliateProgram affiliateProgram)
        {
            this.affiliateProgram = affiliateProgram;
            affiliateProgram.Attach(this);
        }

        public void Update(AffiliateData data)
        {
            Console.WriteLine("Marketing data provided to Affiliates");
        }
        //other methods and properties for marketing data processor
    }
}
