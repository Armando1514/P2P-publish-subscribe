package p2p.auction.mechanism.DAO;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
    private String nickname;
    private String password;
    private Double money;
    private Auction latestAuctionsJoined;
    private ArrayList<Auction> myAuctions;
    private ArrayList<String> unreadedMessages;

    public User() {
        this.unreadedMessages = new ArrayList<>();
        this.myAuctions = new ArrayList<>();

    }
    public User(String nickname, String password, Double money, Auction latestAuctionJoined, Auction myAuctions) {
        this.nickname = nickname;
        this.password = password;
        this.money = money;
        this.latestAuctionsJoined = latestAuctionJoined;
        this.myAuctions = new ArrayList<>();
        this.unreadedMessages = new ArrayList<>();
    }



    public Auction getLatestAuctionsJoined() {
        return latestAuctionsJoined;
    }

    public void setLatestAuctionsJoined(Auction latestAuctionsJoined) {
        this.latestAuctionsJoined = latestAuctionsJoined;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return this.nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ArrayList<String> getUnreadedMessages() {
        return this.unreadedMessages;
    }

    public void setUnreadedMessages(ArrayList<String> unreadedMessages) {
        this.unreadedMessages = unreadedMessages;
    }
    public void setUnreadedMessages(String unreadedMessages) {
        this.unreadedMessages.add(unreadedMessages);
    }

    public ArrayList<Auction> getMyAuctions() {
        return myAuctions;
    }

    public void setMyAuctions(Auction myAuction) {

        this.myAuctions.add(myAuction);
    }

    public User updateElements(User newUser)
    {
        this.password = newUser.password;
        this.money = newUser.money;
        this.latestAuctionsJoined = newUser.latestAuctionsJoined;
        this.myAuctions = newUser.myAuctions;

        if(!this.unreadedMessages.isEmpty())
        {
            if(!newUser.unreadedMessages.isEmpty())
            {

                ArrayList<String> unreaded = newUser.getUnreadedMessages();
                int i = 0;
                while (i < unreaded.size())
                {
                    String message = unreaded.get(i);
                    if(!this.unreadedMessages.contains(message))
                        this.unreadedMessages.add(message);
                    i++;

                }
            }
        }
        else {
            this.setUnreadedMessages(newUser.getUnreadedMessages());

        }

        return this;
    }

}
