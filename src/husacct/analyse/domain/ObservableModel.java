package husacct.analyse.domain;

public interface ObservableModel {

	public void registerObserver(ModelObserver observer);
	public void removeObserver(ModelObserver observer);
	public void notifyObservers();
	
}
