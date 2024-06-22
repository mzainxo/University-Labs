using System;
using System.Collections.Generic;

namespace sda_oel2_zain.Notifications
{
    public class Notification : INotification
    {
        private List<INotificationObserver> observers = new List<INotificationObserver>();
        public void AttachObserver(INotificationObserver observer)
        {
            observers.Add(observer);
            Console.WriteLine("{0} observer attached", observer.GetType().Name);
        }
        public void DetachObserver(INotificationObserver observer)
        {
            observers.Remove(observer);
            Console.WriteLine("{0} observer detached", observer.GetType().Name);
        }
        public void Notify(string message)
        {
            foreach (var observer in observers)
            {
                Console.WriteLine("{0} observer has notified", observer.GetType().Name);
                observer.Update(message);
            }
        }
    }
}
