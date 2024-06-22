using System;
using System.Collections.Generic;

namespace sda_oel2_zain.Affiliation
{
    public interface IAffiliate
    {
        void Attach(IAffiliateObserver observer);
        void Detach(IAffiliateObserver observer);
        void Notify(AffiliateData data);
    }

    public class AffiliateProgram : IAffiliate
    {
        private List<IAffiliateObserver> observers = new List<IAffiliateObserver>();

        public void Attach(IAffiliateObserver observer)
        {
            observers.Add(observer);
            Console.WriteLine("{0} observer attached",observer.GetType().Name);
        }

        public void Detach(IAffiliateObserver observer)
        {
            observers.Remove(observer);
            Console.WriteLine("{0} observer dettached", observer.GetType().Name);
        }

        public void Notify(AffiliateData data)
        {
            foreach (var observer in observers)
            {
                observer.Update(data);
                Console.WriteLine("{0} observer notified", observer.GetType().Name);
            }
        }

        //other methods and properties for affiliate program
    }
}
