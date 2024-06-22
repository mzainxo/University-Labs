using System;

namespace sda_oel2_zain.Notifications
{
    public interface INotification
    {
        void AttachObserver(INotificationObserver observer);
        void DetachObserver(INotificationObserver observer);
        void Notify(string message);
    }
}
