CREATE OR REPLACE FUNCTION add_to_log() RETURNS TRIGGER AS $$
DECLARE
    mstr text;
    astr text;
    retstr text;
BEGIN
    IF TG_OP = 'INSERT' THEN
        astr = NEW.full_name;
        mstr := 'Add new artist: ';
        retstr := mstr || astr;
        INSERT INTO artist_logs(text, added) values (retstr, NOW());
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        astr = NEW.full_name;
        mstr := 'Update artist: ';
        retstr := mstr || astr;
        INSERT INTO artist_logs(text, added) values (retstr, NOW());
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        astr = OLD.full_name;
        mstr := 'Remove artist: ';
        retstr := mstr || astr;
        INSERT INTO artist_logs(text, added) values (retstr, NOW());
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER t_artist
AFTER INSERT OR UPDATE OR DELETE ON artist FOR EACH ROW EXECUTE PROCEDURE add_to_log();