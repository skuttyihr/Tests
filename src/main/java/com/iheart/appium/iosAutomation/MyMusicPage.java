package com.iheart.appium.iosAutomation;

import org.junit.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * MyMusicPage is a huge Page Object for one of the most complicated features of the app - maintaining the main layout of MyMusic for each entitlement user
 * 
 * Fundamentally, the page looks like 3 large square images at the top of the page with text at the bottom and album/artist images embedded (or not) in those images. 
 * Combined with this, the PlaylistHeaderView contains a Playlists Label on the left and a Create New Button on the right -
 *  used to create new playlists(upsell triggers for Free and Plus, modal triggers for alla)
 *  
 *  Below the PlaylistHeaderView is the PlaylistViewCell, a collection of playlists, one usually being My Playlist and others being newest created and as ordered. 
 *  
 *  Free: 
 * @author travisstatham
 *
 */
public class MyMusicPage extends Page{	

	public MyMusicPage() {
		super();
	}

	public MyMusicPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	
	//PlaylistHeaderView  - at top of My Music  (Aids added)
	@iOSFindBy(accessibility = "PlaylistHeaderView-HeaderView-UICollectionReusableView") private IOSElement PlaylistHeaderViewHeaderViewUICollectionReusableView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-PlaylistLabel-UILabel") private IOSElement PlaylistHeaderViewPlaylistLabelUILabel;
	@iOSFindBy(accessibility = "PlaylistHeaderView-CreatePlaylistButton-UIButton") private IOSElement PlaylistHeaderViewCreatePlaylistButtonUIButton;
	@iOSFindBy(accessibility = "PlaylistHeaderView-LineView-UIView") private IOSElement PlaylistHeaderViewLineViewUIView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-SongsBackground-UIImageView") private IOSElement PlaylistHeaderViewSongsBackgroundUIImageView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-AlbumBackground-UIImageView") private IOSElement PlaylistHeaderViewAlbumBackgroundUIImageView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-ArtistBackground-UIImageView") private IOSElement PlaylistHeaderViewArtistBackgroundUIImageView;
	
	//Upsell Cell at bottom of MyMusic (Free users) (AIDs added)
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-UpsellCell-MyMusicUpsellCell") private IOSElement MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-IntroTitle-UILabel") private IOSElement MyMusicUpsellCellIntroTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-Title-UILabel") private IOSElement MyMusicUpsellCellTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-ActionButton-UIButton") private IOSElement MyMusicUpsellCellActionButtonUIButton;
	
	//MyMusicAlbumsView  - CLICK 'ALBUMS' AT TOP OF MY MUSIC TO SHOW THIS. PlaylistHeaderViewAlbumBackgroundUIImageView  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicAlbumsView-AlbumsView-UICollectionView") private IOSElement MyMusicAlbumsViewAlbumsViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-NotAvailableOfflineView-UIView") private IOSElement MyMusicAlbumsViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicAlbumsViewEmptyCellMyMusicEmptyCell;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell3;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-4") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell4;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-5") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell5;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-6") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell6;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-7") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell7;
	//MyMusicAlbumView - Click on an Album in albums view to see the songs in the album!   MyMusicAlbumsViewViewCellUICollectionViewCell0.click()
	@iOSFindBy(accessibility = "MyMusicAlbumView-SongView-UICollectionView") private IOSElement MyMusicAlbumViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicAlbumView-NotAvailableOfflineView-UIView") private IOSElement MyMusicAlbumViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell2;

	@iOSFindBy(accessibility = "MyMusicAlbumView-OverflowBarButtonItem-UIButton") private IOSElement MyMusicAlbumViewOverflowBarButtonItemUIButton;
	
	//MyMusicArtistsView  - Click 'Artists' at top of MyMusic to see all the different artists saved to the account. PlaylistHeaderViewArtistBackgroundUIImageView.click()  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicArtistsView-SongView-UICollectionView") private IOSElement MyMusicArtistsViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicArtistsView-NotAvailableOfflineView-UIView") private IOSElement MyMusicArtistsViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicArtistsView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicArtistsViewEmptyCellMyMusicEmptyCell;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-0") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-1") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-2") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-3") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell3;
	
	//MyMusicArtistSongsView - Click on an Artist to see all the songs saved to your account by that particular artist. (AIDs added)
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-SongView-UICollectionView") private IOSElement MyMusicArtistSongsViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-OverflowBarButtonItem-UIButton") private IOSElement MyMusicArtistSongsViewOverflowBarButtonItemUIButton;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell3;
	
	//MyMusicSongView (aids added)
	@iOSFindBy(accessibility = "MyMusicSongView-SongView-UICollectionView") private IOSElement MyMusicSongViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicSongView-NotAvailableOfflineView-UIView") private IOSElement MyMusicSongViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicSongViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicSongViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicSongViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicSongViewViewCellUICollectionViewCell3;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-4") private IOSElement MyMusicSongViewViewCellUICollectionViewCell4;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-5") private IOSElement MyMusicSongViewViewCellUICollectionViewCell5;
	@iOSFindBy(accessibility = "MyMusicSongView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicSongViewEmptyCellMyMusicEmptyCell;
	
	//MyMusicCollapseableHeader - Top of My Playlist (or another opened Playlist)   (AIDs added)
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Background-UIImageView") private IOSElement MyMusicCollapseableHeaderBackgroundUIImageView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-ContentView-UIView") private IOSElement MyMusicCollapseableHeaderContentViewUIView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-TitleLabel-UILabel") private IOSElement MyMusicCollapseableHeaderTitleLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Logo-UIImageView") private IOSElement MyMusicCollapseableHeaderLogoUIImageView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-PlayButton-UIButton") private IOSElement MyMusicCollapseableHeaderPlayButtonUIButton;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Subtitle1Label-UILabel") private IOSElement MyMusicCollapseableHeaderSubtitle1LabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Subtitle2Label-UILabel") private IOSElement MyMusicCollapseableHeaderSubtitle2LabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-DescriptionLabel-UILabel") private IOSElement MyMusicCollapseableHeaderDescriptionLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-InformationLabel-UILabel") private IOSElement MyMusicCollapseableHeaderInformationLabelUILabel;
	
	//MyMusicEmptyCell  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicEmptyCell-ImageView-UIImageView") private IOSElement MyMusicEmptyCellImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-Title-UILabel") private IOSElement MyMusicEmptyCellTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-Subtitle-UILabel") private IOSElement MyMusicEmptyCellSubtitleUILabel;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-ActionButton-UIButton") private IOSElement MyMusicEmptyCellActionButtonUIButton;
	
	//MyMusicNotAvailableOfflineCell (AIDs added)
	@iOSFindBy(accessibility = "MyMusicNotAvailableOfflineCell-NotAvailableImageView-UIImageView") private IOSElement MyMusicNotAvailableOfflineCellNotAvailableImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicNotAvailableOfflineCell-NotAvailableLabel-UILabel") private IOSElement MyMusicNotAvailableOfflineCellNotAvailableLabelUILabel;
	
	//MyMusicPlaylistHeaderCell - top of a playlist (AIDs added)
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-OfflineLabel-UILabel") private IOSElement MyMusicPlaylistHeaderCellOfflineLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-OfflineSwitch-UISwitch") private IOSElement MyMusicPlaylistHeaderCellOfflineSwitchUISwitch;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleLabel-UILabel") private IOSElement MyMusicPlaylistHeaderCellShuffleLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleButton-UIButton") private IOSElement MyMusicPlaylistHeaderCellShuffleButtonUIButton;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleImageView-UIImageView") private IOSElement MyMusicPlaylistHeaderCellShuffleImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-BottomDivider-UIView") private IOSElement MyMusicPlaylistHeaderCellBottomDividerUIView;
	
	//MyMusicPlaylistViewController - This shows the songs in a playlist while editing it. (AIDs added)
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-SongView-UICollectionView") private IOSElement MyMusicPlaylistViewControllerSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-Header-UICollectionReusableView") private IOSElement MyMusicPlaylistViewControllerHeaderUICollectionReusableView;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-ActivityButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerActivityButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-DoneButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-OverflowBarButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-CancelButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-MyMusicSongCell-MyMusicViewCell-0") private IOSElement MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-MyMusicSongCell-MyMusicViewCell-1") private IOSElement MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1;
	
	//MyMusicPlaylistsViewController - Access this by clicking 'Show All Playlists' - the navigation cell. (Aids added)
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistView-UICollectionView") private IOSElement MyMusicPlaylistsViewControllerPlaylistViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-0") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-1") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-2") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-3") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell3;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-4") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell4;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-DoneButton-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-CancelButton-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-OverflowButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-CreateButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerCreateButtonItemUIBarButtonItem;

	//(AIDs added)
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-DismissLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerDismissLabelUILabel; //Tap anywhere to dismiss
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-TitleLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerTitleLabelUILabel;  //New!
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-SubtitleLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerSubtitleLabelUILabel; //My Playlist contains all your saved songs
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-NavigationCell-MyMusicViewCell") private IOSElement MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell;

	//AIDs added.
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-CollectionView") private IOSElement MyMusicViewPremiumPresenterCollectionView;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-0") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-1") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell1;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-2") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell2;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-3") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell3;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-4") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell4;
	
	//Modal elements that cannot have real accessibilityIDs (most likely to change / break)
	@iOSFindBy(accessibility = "Playlist Name") private IOSElement playlistNameTextBoxCreateNew;
	@iOSFindBy(accessibility = "Create") private IOSElement createPlaylistModalButton;
	@iOSFindBy(accessibility = "Delete Playlist") private IOSElement deletePlaylistOverflowButton;
	@iOSFindBy(accessibility = "Delete") private IOSElement deleteConfirmButton;
	@iOSFindBy(accessibility = "Rename") private IOSElement renamePlaylistOverflowButton;
	@iOSFindBy(accessibility = "Rename Playlist") private IOSElement renamePlaylistNameTextBox;
	@iOSFindBy(accessibility = "Edit") private IOSElement editPlaylistOverflowButton;
	@iOSFindBy(accessibility = "Done") private IOSElement doneEditPlaylistButton;
	@iOSFindBy(accessibility = "Add to Another Playlist") private IOSElement addToPlaylistOverflowButton;
	@iOSFindBy(accessibility = "Manage") private IOSElement managePlaylistButtonOnOverflow;
	@iOSFindBy(accessibility = "Cancel") private IOSElement cancelPlaylistOverflowButton;

	//Use these for Asserts!
	public final String UPSELL_CELL_TITLE_LABEL_FREE_POST_TRIAL = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_TITLE_LABEL_FREE_PRE_TRIAL = "Radio and unlimited music on demand, all in one app.";
	public final String UPSELL_CELL_TITLE_LABEL_PLUS_PRE_TRIAL1 = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_TITLE_LABEL_PLUS_PRE_TRIAL = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_TITLE_LABEL_ALLA_PRE_TRIAL1 = "";
	public final String UPSELL_CELL_TITLE_LABEL_ALLA_PRE_TRIAL = "";
	public final String UPSELL_CELL_INTRO_TITLE_LABEL_FREE_PRE_TRIAL = "INTRODUCING";
	public final String PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_FREE = "PLAYLISTS";
	public final String PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_PLUS = "PLAYLISTS";
	public final String PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_ALLA = "PLAYLISTS";
	public final String INITIAL_MESSAGE_TITLE_LABEL_FREE = "New!";
	public final String INITIAL_MESSAGE_SUBTITLE_LABEL_FREE = "My Playlist contains all your saved songs";
	public final String INITIAL_MESSAGE_DISMISS_LABEL_FREE = "Tap anywhere to dismiss";
	
	/**
	 * Shows all the default elemnts for a Free user on MyMusic. 
	 * The Free user has to have been an ALLA user previously, but they disabled that (trial expired). (post trial)
	 */
	public void showAllElementsForFREEPOSTUsers(){
		System.out.println("Looking for the null pointer 2");
		System.out.println("myMusicPage.showAllElementsForFREEPOSTUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		//MyMusicUpsellCell - ONLY WORKS FOR FREE USER
		System.out.println("Printing out AIDs on bottom of My Music - Upsell Cell");
		printElementInformation(MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell); 
		//printElementInformation(MyMusicUpsellCellIntroTitleUILabel);  //INTRODUCING is not shown on POST Trial Users
		printElementInformation(MyMusicUpsellCellTitleUILabel);       //Your playlists are still here waiting for you.
		printElementInformation(MyMusicUpsellCellActionButtonUIButton);    //works
		//clickMyPlaylist();
		//clickLearnMoreOnMyPlaylist();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickSongsPlaylistButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickLearnMoreUpsellButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//printElementInformation(MyMusicViewPremiumPresenterCollectionView);
	}
	/**
	 * This Free user has never had ALLA before (pre trial). 
	 */
	public void showAllElementsForFREEPREUsers(){
		System.out.println("myMusicPage.showAllElementsForFREEPREUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		//MyMusicUpsellCell - ONLY WORKS FOR FREE USER
		System.out.println("Printing out AIDs on bottom of My Music - Upsell Cell");
		printElementInformation(MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell); 
		printElementInformation(MyMusicUpsellCellIntroTitleUILabel);  //INTRODUCING is shown for users when they still have trial
		printElementInformation(MyMusicUpsellCellTitleUILabel);       //Your playlists are still here waiting for you.
		printElementInformation(MyMusicUpsellCellActionButtonUIButton);    //works - opens upsell modal

	}

	/**
	 * Plus Users have no upsell cell and they still have MyPlaylist
	 */
	public void showAllElementsForPLUSUsers(){
		System.out.println("myMusicPage.showAllElementsForPLUSUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
	}
	/**
	 * This method is run by the MYMU5 test case. 
	 */
	public boolean testEmptySongsAlbumsArtistsPlaylists(){
		boolean albumsEmptyCell,artistsEmptyCell, songsEmptyCell = false; //Use these to assert.
		System.out.println("myMusicPage.showAllElementsForOldALLAUsers() : This ALLA user should be fresh - no saved songs - no prior history - just immediately signed up to ALLA");
		System.out.println("Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		
		//ALBUMS
		clickAlbumsPlaylistButton();
		System.out.println("Printing out AIDs for ALBUMS - Should be empty. ");
		printElementInformation(MyMusicAlbumsViewAlbumsViewUICollectionView);
		printElementInformation(MyMusicAlbumsViewNotAvailableOfflineViewUIView);
		System.out.println("AlbumsView Cell0 should not exist, and expect to see AlbumsView Empty Cell with Search Albums Button. ");
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell0);
		albumsEmptyCell = printElementInformation(MyMusicAlbumsViewEmptyCellMyMusicEmptyCell);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		
		//INITIAL MESSAGE POPUP HANDLING
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			System.out.println("It appears that New! pops up after returning to MyMusic");
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		//SONGS
		clickSongsPlaylistButton();
		System.out.println("Printing out AIDs for Songs - Should be empty. ");
		printElementInformation(MyMusicSongViewSongViewUICollectionView);
		printElementInformation(MyMusicSongViewNotAvailableOfflineViewUIView);
		System.out.println("SongView Cell0 should not exist, and expect to see SongView Empty Cell with Search Songs Button. ");
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell0);
		songsEmptyCell = printElementInformation(MyMusicSongViewEmptyCellMyMusicEmptyCell);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		//ARTISTS
		clickArtistsPlaylistButton();
		System.out.println("Printing out AIDs for Artists - Should be empty. ");
		printElementInformation(MyMusicArtistsViewSongViewUICollectionView);
		printElementInformation(MyMusicArtistsViewNotAvailableOfflineViewUIView);
		System.out.println("ArtistsView Cell0 should not exist, and expect to see ArtistsView Empty Cell with Search Artists Button. ");
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell0);
		artistsEmptyCell = printElementInformation(MyMusicArtistsViewEmptyCellMyMusicEmptyCell);
		//printElementInformation(MyMusicEmptyCellImageViewUIImageView);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		//printElementInformation(MyMusicEmptyCellSubtitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		return songsEmptyCell && artistsEmptyCell && albumsEmptyCell;
	}
	/**
	 * This method is called by MYMU4 to check that Albums work and can be played, and then to show all playlists, 
	 * and click the manage playlists button. Then click done. 
	 * @return
	 */
	public boolean manageAllPlaylists(){
		clickAlbumsPlaylistButton();
		clickEighthAlbumCell();
		//boolean albumSongsWorked = printAlbumSongsPlaylistElements(); AIDS didn't get added, add in later. 
		clickNavBarBackButton();
		clickNavBarBackButton();
		sleep(3000);
		myMusicPage.handleNewInitialMessage();
		clickShowAllPlaylistsCell();
		printShowAllPlaylistsElements();
		clickOverflowBarButtonItemOnShowAllPlaylists();
		clickManagePlaylistsButton();
		boolean manageWorked = printManagePlaylistsElements();
		//clickDoneButtonAfterManagingPlaylists();
		return  manageWorked;
	}

	/**
	 * This ALLA user should have a great deal of music saved to Playlists etc
	 */
	public boolean showAllElementsForOldALLAUsers(){
		boolean playlistCell2, artistCell2, songsCell2, albumsCell2 = false;
		System.out.println("myMusicPage.showAllElementsForOldALLAUsers() : This ALLA user should have a great deal of music saved to Playlists etc");
		System.out.println("Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist and some of the other playlists the user has created.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell1);
		playlistCell2 = printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell2);
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell3);
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell4);
		clickAlbumsPlaylistButton();
		printElementInformation(MyMusicAlbumsViewAlbumsViewUICollectionView);
		printElementInformation(MyMusicAlbumsViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell1);
		albumsCell2 = printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell2);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell3);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell4);
		clickNavBarBackButton();
		sleep(2000);
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			Assert.assertEquals("Initial Message Title Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_TITLE_LABEL_FREE, myMusicPage.getInitialMessageTitleLabel());
			Assert.assertEquals("Initial Message SubTitle Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_SUBTITLE_LABEL_FREE, myMusicPage.getInitialMessageSubtitleLabel());
			Assert.assertEquals("Initial Message Dismiss Label didn't match expected. ", 
					myMusicPage.INITIAL_MESSAGE_DISMISS_LABEL_FREE, myMusicPage.getInitialMessageDismissLabel());
			myMusicPage.dismissInitialMessage();
		}
		clickSongsPlaylistButton();
		printElementInformation(MyMusicSongViewSongViewUICollectionView);
		printElementInformation(MyMusicSongViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell1);
		songsCell2 = printElementInformation(MyMusicSongViewViewCellUICollectionViewCell2);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell3);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell4);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell5);
		clickNavBarBackButton();
		clickArtistsPlaylistButton();
		printElementInformation(MyMusicArtistsViewSongViewUICollectionView);
		printElementInformation(MyMusicArtistsViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell0);
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell1);
		artistCell2 = printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell2);
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell3);
		clickNavBarBackButton();
		
		return playlistCell2 && artistCell2 && songsCell2 && albumsCell2;
	}
	/**
	 * A Playlist has been clicked on in My Music and this prints out the Header Cell, the collection views and buttons, and the collapseable header items. 
	 */
	public void printPlaylistInformation(){
		System.out.println("myMusicPage.printPlaylistInformation()...Prints out elements on Playlist view.");
		printElementInformation(MyMusicPlaylistHeaderCellOfflineLabelUILabel);				//works   Offline
		printElementInformation(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch);			//works   false
		printElementInformation(MyMusicPlaylistHeaderCellShuffleLabelUILabel);				//works   Shuffle
		printElementInformation(MyMusicPlaylistHeaderCellShuffleButtonUIButton);			//works   button
		//MyMusicPlaylistViewController
		printElementInformation(MyMusicPlaylistViewControllerSongViewUICollectionView);					//works
		printElementInformation(MyMusicPlaylistViewControllerHeaderUICollectionReusableView);			//works
		printElementInformation(MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem);  	//works
		//MyMusicCollapseableHeader
		printElementInformation(MyMusicCollapseableHeaderBackgroundUIImageView);
		printElementInformation(MyMusicCollapseableHeaderContentViewUIView);
		printElementInformation(MyMusicCollapseableHeaderTitleLabelUILabel);
		printElementInformation(MyMusicCollapseableHeaderLogoUIImageView);
		printElementInformation(MyMusicCollapseableHeaderPlayButtonUIButton);
		printElementInformation(MyMusicCollapseableHeaderSubtitle1LabelUILabel);
		printElementInformation(MyMusicCollapseableHeaderSubtitle2LabelUILabel);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
	}
	/**
	 * Should be a list of all the saved playlists after clicking Show All Playlists
	 */
	public void printShowAllPlaylistsElements() {
		System.out.println("myMusicPage.printShowAllPlaylistsElements() - Should be a list of all the saved playlists after clicking Show All Playlists");
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistViewUICollectionView);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell3);
		//printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell4);
		printElementInformation(MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem);
		printElementInformation(MyMusicPlaylistsViewControllerCreateButtonItemUIBarButtonItem);
	}

	/**
	 * Should be a list of all the songs in the playlist after clicking Edit Playlist
	 */
	public void printEditPlaylistElements() {
		System.out.println("myMusicPage.printEditPlaylistElements() - Should be a list of all the songs in the playlist after clicking Edit Playlist");
		printElementInformation(MyMusicPlaylistViewControllerSongViewUICollectionView);
		printElementInformation(MyMusicPlaylistViewControllerHeaderUICollectionReusableView);
		printElementInformation(MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem);
		printElementInformation(MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem);
		printElementInformation(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1);
	}
	/**
	 * Should be a list of all the playlists after clicking Manage on the Show All Playlists Overflow button.
	 */
	public boolean printManagePlaylistsElements(){
		System.out.println("myMusicPage.printManagePlaylistsElements() - Should be a list of all the playlists after clicking Manage on the Show All Playlists Overflow button.");
		printElementInformation(MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2);
		return printElementInformation(MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem);
	}
	/**
	 * Should be a list of all the songs within the Album that was clicked on.
	 * returns true if the collectionView is there. 
	 */
	public boolean printAlbumSongsPlaylistElements(){
		System.out.println("myMusicPage.printAlbumSongsPlaylistElements() - Should be a list of all the songs within the Album that was clicked on. ");
		printElementInformation(MyMusicAlbumViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell1);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell2);
		printElementInformation(MyMusicAlbumViewOverflowBarButtonItemUIButton);	
		return printElementInformation(MyMusicAlbumViewSongViewUICollectionView);
	}
	/**
	 * 
	 * 		free - Upsell modal pops up
	 *		plus - Upsell
	 *      alla - opens list of saved Songs
	 */
	public void clickSongsPlaylistButton(){
		System.out.println("myMusicPage.clickSongsPlaylistButton(). ");
		PlaylistHeaderViewSongsBackgroundUIImageView.click();
	}
	/**
	 * 		free - Upsell modal pops up
	 * 		plus - Upsell
	 *      alla - opens list of saved Albums - Albums are clickable and open Album Playlist View. 
	 */
	public void clickAlbumsPlaylistButton(){
		System.out.println("myMusicPage.clickAlbumPlaylistButton(). ");
		PlaylistHeaderViewAlbumBackgroundUIImageView.click();
	}
	/**
	 * 		free - Upsell modal pops up
	 * 		plus - Upsell
	 *      alla - opens list of saved Artists
	 */
	public void clickArtistsPlaylistButton(){
		System.out.println("myMusicPage.clickArtistPlaylistButton(). ");
		PlaylistHeaderViewArtistBackgroundUIImageView.click();
	}
	/**
	 * Gets the text out of the Offline Label - it should just say 'Offline'. 
	 * @return
	 */
	public String getPlaylistHeaderCellOfflineLabelText(){
		String offlineLabel = "";
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellOfflineLabelUILabel, 2)){
			offlineLabel = MyMusicPlaylistHeaderCellOfflineLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getPlaylistHeaderCellOfflineLabelText() : " + offlineLabel);
		return offlineLabel;
	}
	/**
	 *  Gets the text out of the Shuffle Label - it should just say 'Shuffle'
	 * @return
	 */
	public String getPlaylistHeaderCellShuffleLabelText(){
		String shuffleLabel = "";
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellShuffleLabelUILabel, 2)){
			shuffleLabel = MyMusicPlaylistHeaderCellShuffleLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getPlaylistHeaderCellShuffleLabelText() : " + shuffleLabel);
		return shuffleLabel;
	}
	/**
	 * Gets a true or false value depending on the attribute on the IOSElement of the OfflineUISwitch which returns either a string of "true" or "false"
	 * This method converts those to booleans and returns them. 
	 * @return
	 */
	public boolean getPlaylistHeaderCellOfflineSwitchState(){
		String offlineSwitch = "";
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch, 2)){
			offlineSwitch = MyMusicPlaylistHeaderCellOfflineSwitchUISwitch.getAttribute("value");
		}
		System.out.println("myMusicPage.getPlaylistHeaderCellOfflineSwitchText() : " + offlineSwitch);
		if(offlineSwitch.equals("false")){
			return false;
		}else if(offlineSwitch.equals("true")){
			return true;
		}else
		return false;
	}
	public void handleNewInitialMessage(){
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			System.out.println("handleNewInitialMessage() is required.");
			myMusicPage.dismissInitialMessage();
		}
	}
	/**
	 * Feb 24, 2017
     * [ accessibility id: MyMusicCollapseableHeader-Subtitle1Label-UILabel]  text: [Feb 24, 2017]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
     * This returns the date the playlist was last changed (or created...not sure)
	 * @return
	 */
	public String getCollapseableHeaderSubtitle1LabelText(){
		String subtitle1 = "";
		if(waitForElementToBeVisible(MyMusicCollapseableHeaderSubtitle1LabelUILabel, 2)){
			subtitle1 = MyMusicCollapseableHeaderSubtitle1LabelUILabel.getText();
		}
		System.out.println("myMusicPage.getCollapseableHeaderSubtitle1LabelText() : " + subtitle1);
		return subtitle1;
	}
	/**
	 * 0 songs • 0 min
	 * [ accessibility id: MyMusicCollapseableHeader-Subtitle2Label-UILabel]  text: [0 songs • 0 min]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
	 * @return
	 */
	public String getCollapseableHeaderSubtitle2LabelText(){
		String subtitle2 = "";
		if(waitForElementToBeVisible(MyMusicCollapseableHeaderSubtitle2LabelUILabel, 2)){
			subtitle2 = MyMusicCollapseableHeaderSubtitle2LabelUILabel.getText();
		}
		System.out.println("myMusicPage.getCollapseableHeaderSubtitle2LabelText() : " + subtitle2);
		return subtitle2;
	}
	/**
	 * Gets the name of the playlist - playlist must be open.
  	 * [ accessibility id: MyMusicCollapseableHeader-TitleLabel-UILabel]  text: [newPlaylist16441]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
	 * @return
	 */
	public String getCollapseableHeaderTitleLabelText(){
		String titleLabel = "";
		if(waitForElementToBeVisible(MyMusicCollapseableHeaderTitleLabelUILabel, 2)){
			titleLabel = MyMusicCollapseableHeaderTitleLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getCollapseableHeaderTitleLabelText() : " + titleLabel);
		return titleLabel;
	}
	

	/**
	 * 	Tap on the ￼ button next to a song,
	 *  and select Add to Playlist.
	 * @return
	 */
	public String getPlaylistEmptyCellTitleLabelText(){
		String titleLabel = "";
		if(waitForElementToBeVisible(MyMusicEmptyCellTitleUILabel, 2)){
			titleLabel = MyMusicEmptyCellTitleUILabel.getText();
		}
		System.out.println("myMusicPage.getPlaylistEmptyCellTitleLabelText() : " + titleLabel);
		return titleLabel;
	}
	/**
	 * This clicks the Play Button on the Playlist that is currently open. The play Button may also be a pause button. 
	 * @return
	 */
	public boolean clickPlayButtonOnPlaylist(){
		if(waitForElementToBeVisible(MyMusicCollapseableHeaderPlayButtonUIButton, 2)){
			MyMusicCollapseableHeaderPlayButtonUIButton.click();
			System.out.println("myMusicPage.clickPlayButtonOnPlaylist() : true.");
			return true;
		}
		System.out.println("myMusicPage.clickPlayButtonOnPlaylist() : false.");
		return false;
	}
	/**
	 * This clicks the top right overflow (...) button. It will open a modal with other options. 
	 * Delete, Rename, Edit, Add to Another Playlist, Cancel etc
	 * @return
	 */
	public boolean clickPlaylistOverflowButton(){
		if(waitForElementToBeVisible(MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem, 2)){
			MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem.click();
			System.out.println("myMusicPage.clickPlaylistOverflowButton() : true.");
			return true;
		}
		System.out.println("clickPlaylistOverflowButton() : false.");
		return false;
	}
	/**
	 * Clicks the delete Playlist on the Playlist Overflow. A confirm Modal will popup after this. 
	 * @return true if method worked
	 */
	public boolean clickDeletePlaylistOnPlaylistOverflow(){
		if(waitForElementToBeVisible(deletePlaylistOverflowButton, 3)){
			deletePlaylistOverflowButton.click();
			System.out.println("myMusicPage.clickDeletePlaylistOnPlaylistOverflow() : true.");
			return true;
		}
		System.out.println("myMusicPage.clickDeletePlaylistOnPlaylistOverflow() : false.");
		return false;
	}
	/**
	 * This clicks the Delete button to confirm the Delete Playlist. 
	 * It does not use an AID but just searches for the 'Delete' keyword.
	 * @return
	 */
	public boolean clickDeleteToConfirm(){
		if(waitForElementToBeEnabled(deleteConfirmButton, 3)){
			deleteConfirmButton.click();
			System.out.println("myMusicPage.clickDeleteToConfirm() : true. - This should have closed the Delete Playlist modal and landed back on My Music.");
			return true;
		}
		System.out.println("myMusicPage.clickDeletePlaylistOnPlaylistOverflow() : false.");
		return false;
	}
	/**
	 * This clicks the Rename button on the Playlist Overflow. Rename keeps the current playlist name in the modal and then you use another method to add text to it. 
	 * @return
	 */
	public boolean clickRenameOnPlaylistOverflow(){
		if(waitForElementToBeVisible(renamePlaylistOverflowButton, 2)){
			renamePlaylistOverflowButton.click();
			System.out.println("myMusicPage.clickRenameOnPlaylistOverflow() : true.");
			return true;
		}
		System.out.println("myMusicPage.clickRenameOnPlaylistOverflow() : false.");
		return false;
	}
	/**
	 * Checks if the Initial Message dismiss label is currently displayed. 
	 * MyMusicInitialMessageViewControllerDismissLabelUILabel
	 * @return
	 */
	public boolean isCurrentlyOnMyMusicInitialMessage(){
		return isCurrentlyOn("isCurrentlyOnMyMusicInitialMessage", MyMusicInitialMessageViewControllerDismissLabelUILabel);
	}
	/**
	 * This clicks the Dismiss label, even though you can click anywhere on the page to dismiss the method. 
	 * @return
	 */
	public boolean dismissInitialMessage(){
		System.out.println("myMusicPage.dismissInitialMessage() : Clicking Dismiss Label(area) to 'tap anywhere to dismiss'");
		MyMusicInitialMessageViewControllerDismissLabelUILabel.click();
		return isCurrentlyOnMyMusicInitialMessage();
	}

	/**
	 * This checks if the Upsell Cell is displayed
	 * @return
	 */
	public boolean isCurrentlyOnUpsellCell(){
		return isCurrentlyOn("isCurrentlyOnUpsellCell", MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell);
	}
	/**
	 * May have other names instead of just Learn More. 
	 */
	public void clickLearnMoreUpsellButton(){
		System.out.println("myMusicPage.clickLearnMoreUpsellButton(): ");
		MyMusicUpsellCellActionButtonUIButton.click();
	}

	/**
	 * This method clicks the 'Create New' Button on the PlaylistHeaderView on MyMusic
	 * It launches a Create New Playlist Modal that takes in text input. 
	 * Expect to run enterNewPlaylistNameAndClickCreate() next. 
	 */
	public void clickCreateNewPlaylistButton(){
		if(waitForElementToBeVisible(PlaylistHeaderViewCreatePlaylistButtonUIButton, 2)){
			PlaylistHeaderViewCreatePlaylistButtonUIButton.click();
			System.out.println("myMusicPage.clickCreateNewPlaylistButton(): Clicked. ");
		}else{
			System.out.println("myMusicPage.clickCreateNewPlaylistButton(): Couldn't be found. ");
		}
	}
	/**
	 * Not even calling this yet. We can use it once Upsells are in place. 
	 */
	public void clickSubscribeButton(){
		System.out.println("myMusicPage.clickSubscribeButtonOnUpsellCell(). ");
		MyMusicUpsellCellActionButtonUIButton.click();
		//on free - full screen upsell slide up.
	}
	/**
	 * This gets the Playlist Label text. It should return 'PLAYLISTS' - 
	 * this is next to the CREATE NEW button on the PlaylistHeaderView
	 * @return
	 */
	public String getPlaylistsTitle(){
		String playlistLabel = "";
		if(waitForElementToBeVisible(PlaylistHeaderViewPlaylistLabelUILabel, 2)){
			playlistLabel = PlaylistHeaderViewPlaylistLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getPlaylistsTitle() : "+ playlistLabel);
		return playlistLabel;
		//should return PLAYLISTS
	}
	/**
	 * This clicks the First Playlist cell in My Music. For free accounts  this will be the MyPlaylist. 
	 */
	public void clickFirstPlaylistInMyMusic(){
		System.out.println("myMusicPage.clickMyPlaylist(): Clicking the first cell in the Playlist Collection with AID of 0 (if new acct with no playlists, then this is My Playlist)");
		if(waitForElementToBeVisible(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0, 2)){
			MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0.click();
		}
		
	}
	/**
	 * This is prone to breaking as it parses a String and cuts out the first 'word',
	 * but it gets the Number of songs in the playlist. 
	 * @return
	 */
	public int getNumberOfSongsInMyPlaylist(){
		if(waitForElementToBeVisible(MyMusicCollapseableHeaderSubtitle2LabelUILabel, 2)){
			String subtitle2 = MyMusicCollapseableHeaderSubtitle2LabelUILabel.getText();
			String[] split2 = subtitle2.split(" ");
			int returnInt = Integer.parseInt(split2[0]);
			System.out.println("myMusicPage.getNumberOfSongsInMyPlaylist(): " + returnInt);
			return returnInt;
		}
		System.out.println("myMusicPage.getNumberOfSongsInMyPlaylist(): Something went wrong and the 'MyMusicCollapseableHeaderSubtitle2LabelUILabel' wasn't visible.");
		return -1;
	}
	/**
	 * text: [Radio and unlimited music on demand, all in one app.]
	 * @return
	 */
	public String getUpsellCellTitleLabel(){
		String cellTitle = "";
		if(waitForElementToBeVisible(MyMusicUpsellCellTitleUILabel, 2)){
			cellTitle = MyMusicUpsellCellTitleUILabel.getText();
		}
		System.out.println("myMusicPage.getUpsellCellTitleLabel() : "+ cellTitle);
		return cellTitle;
	}
	/**
	 * the Intro label may say INTRODUCING, but this will only appear for Free users who haven't tried ALLA
	 * @return
	 */
	public String getUpsellCellIntroTitleLabel(){
		String introTitle = "";
		if(waitForElementToBeVisible(MyMusicUpsellCellIntroTitleUILabel, 2)){
			introTitle = MyMusicUpsellCellIntroTitleUILabel.getText();
		}
		System.out.println("myMusicPage.getPlaylistsTitle() : "+ introTitle);
		return introTitle;
	}
	/**
	 * This gets the initial Message Title label - this modal pops up on MyMusic after some delay. 
	 * @return
	 */
	public String getInitialMessageTitleLabel(){
		String titleLabel = "";
		if(waitForElementToBeVisible(MyMusicInitialMessageViewControllerTitleLabelUILabel, 2)){
			titleLabel = MyMusicInitialMessageViewControllerTitleLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getInitialMessageTitleLabel() : "+ titleLabel);
		return titleLabel;
	}
	/**
	 * Gets the Subtitle Label text in the Initial Message upsell. 
	 * @return
	 */
	public String getInitialMessageSubtitleLabel(){
		String subtitleLabel = "";
		if(waitForElementToBeVisible(MyMusicInitialMessageViewControllerSubtitleLabelUILabel, 2)){
			subtitleLabel = MyMusicInitialMessageViewControllerSubtitleLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getInitialMessageSubtitleLabel() : "+ subtitleLabel);
		return subtitleLabel;
	}
	/**
	 * //Tap anywhere to dismiss
	 * @return
	 */
	public String getInitialMessageDismissLabel(){
		String dismissLabel = "";
		if(waitForElementToBeVisible(MyMusicInitialMessageViewControllerDismissLabelUILabel, 2)){
			dismissLabel = MyMusicInitialMessageViewControllerDismissLabelUILabel.getText();
		}
		System.out.println("myMusicPage.getInitialMessageDismissLabel() : "+ dismissLabel);
		return dismissLabel;
	}
	/**
	 * This enters the string param into the new playlist modal and clicks the Create button. 
	 * Expect this playlist to pop up into the first cell in MyMusic.
	 * @param string
	 * @return
	 */
	public String enterNewPlaylistNameAndClickCreate(String string) {
		System.out.println("myMusicPage.enterNewPlaylistNameAndClickCreate() : "+ string);
		playlistNameTextBoxCreateNew.sendKeys(string);
		System.out.println("myMusicPage.Clicking on 'Create' button");
		createPlaylistModalButton.click();
		return string;
		
	}
	/**
	 * This appends text to the Rename dialog's textbox which already contains the current playlist. 
	 * @param string
	 * @return
	 */
	public String enterRenamedPlaylistOnPlaylistOverflow(String string) {
		System.out.println("myMusicPage.enterRenamedPlaylistOnPlaylistOverflow() : "+ string  + ". Appending the string to the current playlist Name then clicking Rename.");
		if(waitForElementToBeVisible(renamePlaylistNameTextBox, 2)){
			renamePlaylistNameTextBox.sendKeys(string);
			renamePlaylistOverflowButton.click();
			return string;
		}
		return "Rename didn't work.";
		
	}
	/**
	 * This clicks the Search Songs button on an empty playlist of Songs, Albums, or Artists. Should go to Search Page.
	 * @return
	 */
	public boolean clickSearchActionButtonOnEmptyPlaylist(){
		boolean didClick = false;
		if(waitForElementToBeVisible(MyMusicEmptyCellActionButtonUIButton, 2)){
			MyMusicEmptyCellActionButtonUIButton.click();
			didClick = true;
		}
		System.out.println("myMusicPage.clickSearchActionButtonOnEmptyPlaylist() : " + didClick);
		return didClick;	
	}

	/**
	 * Clicks the Offline button to make the opened Playlist offline. It will 'download' the songs but we can't test if those are playable in SIMULATOR
	 * @return
	 */
	public boolean clickOfflineButtonOnPlaylist(){
		boolean didClick = false;
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch, 2)){
			MyMusicPlaylistHeaderCellOfflineSwitchUISwitch.click();
			didClick = true;
		}
		System.out.println("myMusicPage.clickOfflineButtonOnPlaylist() :" + didClick);
		return didClick;	
	}
	/**
	 * This clicks the Shuffle button. 
	 * @return
	 */
	public boolean clickShuffleButtonOnPlaylist(){
		boolean didClick = false;
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellShuffleButtonUIButton, 2)){
			MyMusicPlaylistHeaderCellShuffleButtonUIButton.click();
			didClick = true;
		}
		System.out.println("myMusicPage.clickShuffleButtonOnPlaylist() : " + didClick);
		return didClick;
		
	}
	/**
	 * After clicking the Playlist Overflow button, you can click Edit if there are songs within the playlist. 
	 */
	public void clickEditOnPlaylistOverflow() {
		if(waitForElementToBeVisible(editPlaylistOverflowButton, 2)){
			editPlaylistOverflowButton.click();
			System.out.println("myMusicPage.clickEditOnPlaylistOverflow() : Clicked.");
		}else{
			System.out.println("myMusicPage.clickEditOnPlaylistOverflow() : COULD NOT CLICK");
		}
	}
	/**
	 * This clicks the Done button in the top right of the Edit Playlist. 
	 */
	public void clickDoneButtonWhileEditingPlaylist() {
		if(waitForElementToBeVisible(MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem, 2)){
			MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem.click();
			System.out.println("myMusicPage.clickDoneButtonWhileEditingPlaylist() : MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem Clicked.");
		}
	}
	/**
	 * This clicks the Cancel button on the top left of the Edit Playlist. 
	 */
	public void clickCancelButtonWhileEditingPlaylist() {
		if(waitForElementToBeVisible(MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem, 2)){
			MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem.click();
			System.out.println("myMusicPage.clickCancelButtonWhileEditingPlaylist() : MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem Clicked.");
		}
	}
	/**
	 * This clicks the Show All Playlists Cell when there are 2 or more playlists. 
	 */
	public void clickShowAllPlaylistsCell(){
		if(waitForElementToBeVisible(MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell, 2)){
			MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell.click();
			System.out.println("myMusicPage.clickShowAllPlaylistsCell() : MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell Clicked.");
		}
	}
	/**
	 * Clicks the Overflow button on the Playlists screen. 
	 * Manage is available, so is Create New Playlist.
	 */
	public void clickOverflowBarButtonItemOnShowAllPlaylists(){
		if(waitForElementToBeVisible(MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem, 2)){
			MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem.click();
			System.out.println("myMusicPage.clickOverflowBarButtonItemOnShowAllPlaylists() : MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem Clicked.");
		}
	}
	/**
	 * This clicks the Manage Playlists modal button. Doesn't use AID. 
	 */
	public void clickManagePlaylistsButton(){
		if(waitForElementToBeVisible(managePlaylistButtonOnOverflow, 2)){
			managePlaylistButtonOnOverflow.click();
			System.out.println("myMusicPage.clickManagePlaylist() : managePlaylistButtonOnOverflow Clicked.");
		}
	}
	/**
	 * This clicks the First album cell in the list of albums. 
	 */
	public void clickFirstAlbumCell(){
		if(waitForElementToBeVisible(MyMusicAlbumsViewViewCellUICollectionViewCell0, 2)){
			MyMusicAlbumsViewViewCellUICollectionViewCell0.click();
			System.out.println("myMusicPage.clickFirstAlbumCell() : MyMusicAlbumsViewViewCellUICollectionViewCell0 Clicked.");
		}
	}
	/**
	 * This clicks the Second album cell in the list of albums. 
	 */
	public void clickSecondAlbumCell(){
		if(waitForElementToBeVisible(MyMusicAlbumsViewViewCellUICollectionViewCell1, 2)){
			MyMusicAlbumsViewViewCellUICollectionViewCell1.click();
			System.out.println("myMusicPage.clickSecondAlbumCell() : MyMusicAlbumsViewViewCellUICollectionViewCell1 Clicked.");
		}
	}
	/**
	 * This clicks the Second album cell in the list of albums. 
	 */
	public void clickEighthAlbumCell(){
		if(waitForElementToBeVisible(MyMusicAlbumsViewViewCellUICollectionViewCell7, 2)){
			MyMusicAlbumsViewViewCellUICollectionViewCell7.click();
			System.out.println("myMusicPage.clickEighthAlbumCell() : MyMusicAlbumsViewViewCellUICollectionViewCell7 Clicked.");
		}
	}
	/**
	 * This clicks the Done button once you've managed the playlists (deleted or moved order). 
	 */
	public void clickDoneButtonAfterManagingPlaylists(){
		if(waitForElementToBeVisible(MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem, 2)){
			MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem.click();
			System.out.println("myMusicPage.clickDoneButtonAfterManagingPlaylists() : MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem Clicked.");
		}
	}
	/**
	 * This clicks the Done button once you've managed the playlists (deleted or moved order). 
	 */
	public void clickCancelButtonAfterManagingPlaylists(){
		if(waitForElementToBeVisible(MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem, 2)){
			MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem.click();
			System.out.println("myMusicPage.clickCancelButtonAfterManagingPlaylists() : MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem Clicked.");
		}
	}
	/**
	 * Clicks the first song on My Playlist. This could be used to demonstrate Plus allows MyPlaylist playback. 
	 * This also clicks the second MyMusicSongCell, the  first one has Offline Label etc
	 */
	public void clickFirstSongOnPlaylist(){
		if(waitForElementToBeVisible(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1, 2)){
		MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1.click();
		System.out.println("myMusicPage.clickFirstSongOnPlaylist() : MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1 Clicked.");
		}
	}

}
